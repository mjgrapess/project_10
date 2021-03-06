/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.sql.Timestamp;
import javax.swing.JOptionPane;
import model.dao.LoginInfoDAO;
import model.to.LoginInfoTO;
import operations.Validations;
import screens.adminscreen.AdminMainScreen;
import screens.userscreen.UserMainScreen;

/**
 *
 * @author Grapess
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnLogin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jpfPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("Enter User Name :");

        jtfUserName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel2.setText("Enter User Password :");

        jpfPassword.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin.setText("Click To Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jtfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpfPassword))
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jpfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String uname = jtfUserName.getText();
        String pass = new String(jpfPassword.getPassword());
        String message = "";
        if (Validations.isEmpty(uname) || Validations.isEmpty(pass)) {
            message = "Please Enter Some Value";
        } else if (uname.equals("master") && pass.equals("master_123")) {
            AdminMainScreen ams = new AdminMainScreen(uname);
            ams.setVisible(true);
            message = "Welcome Master!!!!";
            dispose();
        } else {
            LoginInfoDAO action = new LoginInfoDAO();
            LoginInfoTO record = action.getRecord(uname);
            if (record != null) {
                if (record.getPassword().equals(pass)) {
                    if (record.getRolename().equals("admin")) {
                        AdminMainScreen ams = new AdminMainScreen();
                        ams.setVisible(true);
                        if (record.getLastlogin() == null) {
                            message = "Welcome First Time!!!";
                        } else {
                            message = "Your Last Visit : " + record.getLastlogin();
                        }
                        record.setLastlogin(new Timestamp(System.currentTimeMillis()));
                        action.updateRecord(record);
                        dispose();
                    } else if (record.getRolename().equals("user")) {
                        UserMainScreen ums = new UserMainScreen(uname);
                        ums.setVisible(true);
                        if (record.getLastlogin() == null) {
                            message = "Welcome First Time!!!";
                        } else {
                            message = "Your Last Visit : " + record.getLastlogin();
                        }
                        record.setLastlogin(new Timestamp(System.currentTimeMillis()));
                        action.updateRecord(record);
                        dispose();
                    } else {
                        message = "Insufficient Privileges Contact To Administrator";
                    }
                } else {
                    message = "Invalid User Name and Password";
                }
            } else {
                message = "Invalid User Name and Password";
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
}
