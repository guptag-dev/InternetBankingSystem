import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

/**
 * This Class is Derived from the class GeneratePDF Every function and every
 * variable defined here is available in all object. This class is used for
 * issuing a draft as per request of user.
 * 
 * 
 * @author Teenovators
 * @version 1.0, 03 NOV 2008
 * @see GeneratePDF
 */
public class DraftIssue extends GeneratePDF implements javax.servlet.Servlet{
	static final long	serialVersionUID	= 1L;
	/**
	 * Contains the Account Type
	 */
	private String	  type;
	
	/**
	 * Contains the User ID
	 */
	private String	  UserID;
	
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */

	/**
	 * Default Constructor.
	 */
	public DraftIssue()
	{
		super();
	}
	
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		
		try
		{
			// Create a session variable
			HttpSession draftSession = CreateHttpSession(request);
			// Get value of cookie for this session
			UserID = GetFromCookie("loginsession", draftSession);
			type = GetFromCookie("type", draftSession);
			
			// pw.println("starting ");
			if(UserID.equals("F"))
				// User is not currently logged in
				response.sendRedirect("index.jsp");
			else
			{
				// pw.println("logged in");
				// Get parameter from request
				String payTo = request.getParameter("payTo");
				// pw.println(payTo);
				float amount = Float.parseFloat(request
				        .getParameter("amount_dd"));
				// pw.println(amount);
				String payableAt = request.getParameter("payAt");
				// pw.println(payableAt );
				long accountNumber = Long.parseLong((request
				        .getParameter("account")));
				// pw.println(accountNumber);
				String transactionPassword = request.getParameter("trans_pass");
				// pw.println(transactionPassword);
				int mode = Integer.parseInt(request.getParameter("mode"));
				// pw.println(mode);
				
				// local variables
				int transactionID;
				int draftNumber;
				float limit;
				String query = "";
				String responsePacket = "";
				boolean isValid;
				String date = getCurrentDate(); // get current date from
				// function defined in DBConnect
				String time = getCurrentTime(); // get current time from
				// function defined in DBConnect
				
				// Get connection from database pool
				Connection draftConnection = getDBConnection();
				// Create a connection statement
				Statement paymentStatement = CreateQueryStatement(draftConnection);
				ResultSet draftResult;
				// pw.println("connection made");
				
				// To issue a draft
				// 1. verify transaction password
				// 2. verify amount < draftLimit
				// 3. credit amount from the account number
				// 4. create entries in draft table
				
				if(type.equals("Personal"))
					isValid = VarifyTransactionPassword(paymentStatement,
					        transactionPassword, UserID, true, pw);
				else
					isValid = VarifyTransactionPassword(paymentStatement,
					        transactionPassword, UserID, false, pw);
				
				// pw.println("Yahan tak aa gaya, yippppppeeeee");
				
				if(!isValid)
					// bad password
					responsePacket = "{'success':false,'data':'Bad Password, Please check your password and re-enter'}";
				else
				{ // transaction password is correct
				
					query = "select draftLimit from accountDetails where accountDetails.accountNumber="
					        + accountNumber;
					// pw.println(query);
					draftResult = ExecuteQuery(query, paymentStatement, true);
					
					if(draftResult.next())
					{
						// calculate limit of the particular account
						limit = draftResult.getFloat("draftLimit");
						
						if(amount <= limit)
						{
							// amount filled is less than limit so continue
							
							// To fill information in credit table
							// calculate draft number if successful
							draftNumber = getCount("draftID", paymentStatement,
							        pw) + 1;
							// calculate transaction ID if successful
							transactionID = getCount("transactionID",
							        paymentStatement, pw) + 1;
							
							// additional charges for draft
							
							// mode is courier mode so deduct extra amount
							float deductableAmount;
							if(mode == 1)
								deductableAmount = amount + 50 + 50;
							// mode is simple recipt mode
							else
								deductableAmount = amount + 50;
							
							boolean isDebited = DebitFromAccount(
							        paymentStatement, accountNumber,
							        deductableAmount,
							        "Debited for draft number " + draftNumber
							                + " of " + amount + " rupees",
							        transactionID);
							
							if(isDebited)
							{
								// amount has been credited generate draft
								// number and make entries
								
								// update draftID count in count table
								updateCountByOne("draftID", paymentStatement,
								        pw);
								// update transactionID count in count table
								updateCountByOne("transactionID",
								        paymentStatement, pw);
								
								// make entry in transaction Table
								makeTransactionEntries(transactionID, date,
								        time, paymentStatement, pw);
								
								// To print recipt
								// make entries in draft table and print the
								// draft
								// current dir
								String dir = generateCurrentDirPath();
								String path = dir + "content\\Draft"
								        + accountNumber + ".pdf"; // for
								// window
								// server
								// String path =
								// dir+"content/Draft"+accountNumber+".pdf";
								// //for linux server
								// Initializing a document of given
								// specification
								Rectangle pageSize = new Rectangle(815, 400);
								Document document = new Document(pageSize);
								// Initializing pdfWriter to write the document
								PdfWriter writer = PdfWriter
								        .getInstance(document,
								                new FileOutputStream(path));
								// open the document to write and document is
								// protected variable of GeneratePDF
								document.open();
								// Write image
								Image img = Image.getInstance(dir+"images\\draft.bmp");
								img.setAbsolutePosition(0,0);
								document.add(img);
							
								if(mode == 1)
								{
									query = "insert into Draft values("
									        + accountNumber + ",'" + payTo
									        + "'," + amount + ",'" + payableAt
									        + "','issued','courier',"
									        + draftNumber + ")";
									generateDraftPDF(accountNumber, payTo,
									        amount, payableAt, "Courier", date,
									        time, draftNumber,document);
								}
								else
								{
									query = "insert into Draft values("
									        + accountNumber + ",'" + payTo
									        + "'," + amount + ",'" + payableAt
									        + "','delivered','direct',"
									        + draftNumber + ")";
									generateDraftPDF(accountNumber, payTo,
									        amount, payableAt, "Self", date,
									        time, draftNumber,document);
								}
								
								// pw.println(query);
								// Draft(acNumber bigint,favour
								// varchar(100),amount float,payable
								// varchar(100),status varchar(100),mode
								// varchar(10),draftNum int)
								ExecuteQuery(query, paymentStatement, false);
								document.close();
								responsePacket = "{'success':true,'data':'"
								        + path + "'}";
								
							}
							else
								// balance is not sufficient in your account
								responsePacket = "{'success':false,'data':'Your account balance is not sufficient to perform this operation'}";
						}
						else
							// amout exceeded the limit
							responsePacket = "{'success':false,'data':'Amount has been exceeded than limit set by you'}";
					}
				}
				
				pw.println(responsePacket);
				
			}
		}
		catch (Exception ex)
		{
			// exception occurred
			response.sendRedirect("index.jsp");
			// pw.println(ex.getMessage());
		}
	}
}