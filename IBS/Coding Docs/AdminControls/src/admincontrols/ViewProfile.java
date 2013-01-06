/*
 * ViewProfile.java
 *
 * Created on November 2, 2008, 11:03 AM
 */

package admincontrols;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author  Administrator
 */
public class ViewProfile extends javax.swing.JFrame {
    private String MyUser;
    DBConnect DBC;
    Connection DBConn;
    Statement DBStmt;
    ResultSet Result;
    /** Creates new form ViewProfile */
    public ViewProfile(String User) {
        initComponents();
        MyUser=User;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewProfile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        UserNameField = new javax.swing.JTextField();
        AdressField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        EmailField = new javax.swing.JTextField();
        IDProof = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DefaultAccountField = new javax.swing.JTextField();
        LoginDate = new javax.swing.JTextField();
        LoginTime = new javax.swing.JTextField();
        UpdatePhone = new javax.swing.JButton();
        UpdateEmail = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TypeOfUser = new javax.swing.JTextField();
        UpdateAdress = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("View Profile"); // NOI18N
        setResizable(false);

        ViewProfile.setName("ViewProfile"); // NOI18N
        ViewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewProfileMouseClicked(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(admincontrols.AdminControlsApp.class).getContext().getResourceMap(ViewProfile.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        NameField.setEditable(false);
        NameField.setName("NameField"); // NOI18N

        UserNameField.setEditable(false);
        UserNameField.setName("UserNameField"); // NOI18N

        AdressField.setName("AdressField"); // NOI18N

        PhoneField.setName("PhoneField"); // NOI18N

        EmailField.setName("EmailField"); // NOI18N

        IDProof.setEditable(false);
        IDProof.setName("IDProof"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        DefaultAccountField.setEditable(false);
        DefaultAccountField.setName("DefaultAccountField"); // NOI18N

        LoginDate.setEditable(false);
        LoginDate.setName("LoginDate"); // NOI18N

        LoginTime.setEditable(false);
        LoginTime.setName("LoginTime"); // NOI18N

        UpdatePhone.setText(resourceMap.getString("UpdatePhone.text")); // NOI18N
        UpdatePhone.setName("UpdatePhone"); // NOI18N
        UpdatePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdatePhoneMouseReleased(evt);
            }
        });
        UpdatePhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePhoneActionPerformed(evt);
            }
        });

        UpdateEmail.setText(resourceMap.getString("UpdateEmail.text")); // NOI18N
        UpdateEmail.setName("UpdateEmail"); // NOI18N
        UpdateEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateEmailMouseReleased(evt);
            }
        });

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        TypeOfUser.setEditable(false);
        TypeOfUser.setText(resourceMap.getString("TypeOfUser.text")); // NOI18N
        TypeOfUser.setName("TypeOfUser"); // NOI18N

        UpdateAdress.setText(resourceMap.getString("UpdateAdress.text")); // NOI18N
        UpdateAdress.setName("UpdateAdress"); // NOI18N
        UpdateAdress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UpdateAdressMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout ViewProfileLayout = new javax.swing.GroupLayout(ViewProfile);
        ViewProfile.setLayout(ViewProfileLayout);
        ViewProfileLayout.setHorizontalGroup(
            ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewProfileLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(24, 24, 24)
                .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DefaultAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDProof, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ViewProfileLayout.createSequentialGroup()
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TypeOfUser)
                            .addComponent(NameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdressField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewProfileLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UpdateEmail)
                                    .addComponent(UpdatePhone)
                                    .addComponent(UpdateAdress, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewProfileLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ViewProfileLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(LoginTime, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ViewProfileLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(LoginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        ViewProfileLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {UpdateAdress, UpdateEmail, UpdatePhone});

        ViewProfileLayout.setVerticalGroup(
            ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(LoginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewProfileLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(UpdateAdress))
                        .addGap(18, 18, 18)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(UpdatePhone))
                        .addGap(18, 18, 18)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(UpdateEmail))
                            .addComponent(jLabel5))
                        .addGap(16, 16, 16)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDProof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DefaultAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(ViewProfileLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(ViewProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(LoginTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );

        jLabel10.setFont(resourceMap.getFont("jLabel10.font")); // NOI18N
        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addGap(27, 27, 27)
                .addComponent(ViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewProfileMouseClicked

    private void UpdatePhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePhoneActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_UpdatePhoneActionPerformed

    private void UpdateAdressMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateAdressMouseReleased
        // TODO add your handling code here:
        String Address = AdressField.getText();
        String query = null;
        int userid;
        
        if(Address.equals("")){
            JOptionPane pane = new JOptionPane();
            pane.showMessageDialog(null,"Adress field can not be empty !!","Error!",1);
        }
        else{
            try {
                DBC = new DBConnect();
                DBConn = DBC.getDBConnection();
                DBStmt = DBC.CreateQueryStatement(DBConn);
                String UserType = TypeOfUser.getText();
                
                if (UserType.equals("Personal")) {
                    query = "SELECT * FROM ADMINISTRATOR.PLOGININFO where Administrator.plogininfo.username='" + MyUser + "'";
                } else {
                    
                    query = "SELECT * FROM ADMINISTRATOR.CLOGININFO where Administrator.clogininfo.username='" + MyUser + "'";
                }
                Result = DBC.ExecuteQuery(query, DBStmt, true);

                Result.next();
                userid = Result.getInt("userID");
                String Query = "UPDATE ADMINISTRATOR.MYPROFILE SET ADMINISTRATOR.MYPROFILE.MYADDRESS='"+ Address +"' WHERE ADMINISTRATOR.MYPROFILE.USERID=" + userid;
                
                DBConn.close();
                
                JOptionPane JP = new JOptionPane();
                JP.showMessageDialog(null,"Adress updated successfully\n It will be visible next time","Info",1);
                
            } catch (SQLException ex) {
                Logger.getLogger(ViewProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_UpdateAdressMouseReleased

    private void UpdatePhoneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdatePhoneMouseReleased
        // TODO add your handling code here:
        String Phone = PhoneField.getText();
        String query = null;
        int userid;
        
        if(Phone.equals("")){
            JOptionPane pane = new JOptionPane();
            pane.showMessageDialog(null,"Adress field can not be empty !!","Error!",1);
        }
        else{
            try {
                DBC = new DBConnect();
                DBConn = DBC.getDBConnection();
                DBStmt = DBC.CreateQueryStatement(DBConn);
                String UserType = TypeOfUser.getText();
                
                if (UserType.equals("Personal")) {
                    query = "SELECT * FROM ADMINISTRATOR.PLOGININFO where Administrator.plogininfo.username='" + MyUser + "'";
                } else {
                    
                    query = "SELECT * FROM ADMINISTRATOR.CLOGININFO where Administrator.clogininfo.username='" + MyUser + "'";
                }
                Result = DBC.ExecuteQuery(query, DBStmt, true);

                Result.next();
                userid = Result.getInt("userID");
                String Query = "UPDATE ADMINISTRATOR.MYPROFILE SET ADMINISTRATOR.MYPROFILE.myPhone='"+ Phone +"' WHERE ADMINISTRATOR.MYPROFILE.USERID=" + userid;
                
                DBConn.close();
                
                JOptionPane JP = new JOptionPane();
                JP.showMessageDialog(null,"Phone number updated successfully\n It will be visible next time","Info",1);
                
            } catch (SQLException ex) {
                Logger.getLogger(ViewProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_UpdatePhoneMouseReleased

    private void UpdateEmailMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateEmailMouseReleased
        // TODO add your handling code here:
        String Email = EmailField.getText();
        String query = null;
        int userid;
        
        if(Email.equals("")){
            JOptionPane pane = new JOptionPane();
            pane.showMessageDialog(null,"Adress field can not be empty !!","Error!",1);
        }
        else{
            try {
                DBC = new DBConnect();
                DBConn = DBC.getDBConnection();
                DBStmt = DBC.CreateQueryStatement(DBConn);
                String UserType = TypeOfUser.getText();
                
                if (UserType.equals("Personal")) {
                    query = "SELECT * FROM ADMINISTRATOR.PLOGININFO where Administrator.plogininfo.username='" + MyUser + "'";
                } else {
                    
                    query = "SELECT * FROM ADMINISTRATOR.CLOGININFO where Administrator.clogininfo.username='" + MyUser + "'";
                }
                Result = DBC.ExecuteQuery(query, DBStmt, true);

                Result.next();
                userid = Result.getInt("userID");
                String Query = "UPDATE ADMINISTRATOR.MYPROFILE SET ADMINISTRATOR.MYPROFILE.mail='"+ Email +"' WHERE ADMINISTRATOR.MYPROFILE.USERID=" + userid;
                
                DBConn.close();
                
                JOptionPane JP = new JOptionPane();
                JP.showMessageDialog(null,"Email-ID updated successfully\n It will be visible next time","Info",1);
                
            } catch (SQLException ex) {
                Logger.getLogger(ViewProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_UpdateEmailMouseReleased
    
        public int SetMyProfile(int UserType) {
        
        int userid=0;
        String queryOne = null;
        String queryTwo;
        int returnValue =0;
        
        DBConnect DBC = new DBConnect();
        Connection c;
        ResultSet Result;
        Statement S;
        c = DBC.getDBConnection();
        S = DBC.CreateQueryStatement(c);
        
        if(UserType==0){
            queryOne = "SELECT * FROM ADMINISTRATOR.PLOGININFO where Administrator.Plogininfo.username='" + MyUser + "'";
            TypeOfUser.setText("Personal");
        }
        else if(UserType==1){
            queryOne = "SELECT * FROM ADMINISTRATOR.CLOGININFO where Administrator.Clogininfo.username='" + MyUser + "'";
            TypeOfUser.setText("Corporate");
        }
        
        try {
                
                Result = DBC.ExecuteQuery(queryOne, S, true);

                if (Result.next()) {
                    userid = Result.getInt(6);
                    
                    DefaultAccountField.setText(Result.getString("defaultAccount"));
                    
                    Date Day = Result.getDate("lastloginDate");
                    Time T = Result.getTime("lastlogintime");
                    
                    LoginDate.setText(Day.getDate()+"/"+Day.getMonth()+"/"+Day.getYear());
                    LoginTime.setText(Integer.toString(T.getHours())+":"+Integer.toString(T.getMinutes())+":"+Integer.toString(T.getSeconds()));
                

                    queryTwo = "select * from Administrator.myprofile where Administrator.myprofile.userid="+userid;
                    Result=DBC.ExecuteQuery(queryTwo, S, true);

                    if(Result.next()) {
                        UserNameField.setText(MyUser);
                        NameField.setText(Result.getString(2));
                        AdressField.setText(Result.getString(3));
                        PhoneField.setText(Result.getString(4));
                        EmailField.setText(Result.getString(5));
                        IDProof.setText(Result.getString(6));
                    }
                    returnValue = 0;
                }
                else {
                   JOptionPane JP = new JOptionPane();
                   JP.showMessageDialog(null,"Username not found","ERROR",0);
                   returnValue = -1;
                }        
        
        } catch (SQLException ex) {
            Logger.getLogger(AdminControlsView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return returnValue;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ViewProfile().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdressField;
    private javax.swing.JTextField DefaultAccountField;
    private javax.swing.JTextField EmailField;
    private javax.swing.JTextField IDProof;
    private javax.swing.JTextField LoginDate;
    private javax.swing.JTextField LoginTime;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JTextField TypeOfUser;
    private javax.swing.JButton UpdateAdress;
    private javax.swing.JButton UpdateEmail;
    private javax.swing.JButton UpdatePhone;
    private javax.swing.JTextField UserNameField;
    private javax.swing.JPanel ViewProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
    
}
