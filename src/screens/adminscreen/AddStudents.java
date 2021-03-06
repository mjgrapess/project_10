/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.adminscreen;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.dao.CommonDAO;
import model.dao.StudentPhotosDAO;
import model.dao.StudentsDAO;
import model.to.StudentPhotosTO;
import model.to.StudentsTO;
import operations.CommonOperations;
import operations.ErrorHandler;
import operations.Validations;

/**
 *
 * @author Grapess
 */
public class AddStudents extends javax.swing.JInternalFrame {

    private String image_path;

    public AddStudents() {
        initComponents();
        jcbMaritalStaus.removeAllItems();
        jcbMaritalStaus.addItem("Choose Marital Status");
        jcbMaritalStaus.addItem("Single");
        jcbMaritalStaus.addItem("Married");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupGender = new javax.swing.ButtonGroup();
        lblPic = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfFatherName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfContactNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbMaritalStaus = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jrbMale = new javax.swing.JRadioButton();
        jrbOthers = new javax.swing.JRadioButton();
        jrbFeMale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cdpDob = new controls.CurrentDatePanel();
        btnChoose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Students");

        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/no_image.gif"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel1.setText("Enter Name :");

        jtfName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel2.setText("Enter Father Name :");

        jtfFatherName.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel3.setText("Enter Contact No :");

        jtfContactNo.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jtfContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfContactNoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel4.setText("Choose Marital Status :");

        jcbMaritalStaus.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jcbMaritalStaus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel5.setText("Choose Gender :");

        groupGender.add(jrbMale);
        jrbMale.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jrbMale.setText("Male");

        groupGender.add(jrbOthers);
        jrbOthers.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jrbOthers.setText("Others");

        groupGender.add(jrbFeMale);
        jrbFeMale.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jrbFeMale.setText("FeMale");

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel6.setText("Choose Date Of Birth :");

        btnChoose.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnChoose.setText("Choose Pics...");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSave.setText("Add Student Details");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfFatherName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                                    .addComponent(jcbMaritalStaus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrbMale)
                                        .addGap(18, 18, 18)
                                        .addComponent(jrbFeMale)
                                        .addGap(18, 18, 18)
                                        .addComponent(jrbOthers)))))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(cdpDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPic))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcbMaritalStaus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jrbMale)
                            .addComponent(jrbOthers)
                            .addComponent(jrbFeMale)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cdpDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        JFileChooser jfc = new JFileChooser();
        int result = jfc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = jfc.getSelectedFile().getAbsolutePath();
            if (Validations.isValidImage(path)) {
                image_path = path;
                try {
                    BufferedImage img;
                    img = ImageIO.read(new File(image_path));
                    Image dimg = img.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(dimg);
                    lblPic.setIcon(icon);
                } catch (Exception ex) {
                    image_path = null;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Format of Image Selected");
            }
        }
    }//GEN-LAST:event_btnChooseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String message = "";
        boolean allvalid = true;
        String name = jtfName.getText().trim();
        String fathername = jtfFatherName.getText().trim();
        String contactno = jtfContactNo.getText().trim();
        String gender = "";
        String maritalstatus = "";
        Date dob = cdpDob.getSelectedDate();
        if (jrbMale.isSelected()) {
            gender = jrbMale.getText();
        } else if (jrbFeMale.isSelected()) {
            gender = jrbFeMale.getText();
        } else if (jrbOthers.isSelected()) {
            gender = jrbOthers.getText();
        }
        if (jcbMaritalStaus.getSelectedIndex() > 0) {
            maritalstatus = jcbMaritalStaus.getSelectedItem().toString();
        }
        if (Validations.isEmpty(name)) {
            message += "Please Enter Some Value in Name Box\n";
            allvalid = false;
        }
        if (Validations.isEmpty(fathername)) {
            message += "Please Enter Some Value in Father Name Box\n";
            allvalid = false;
        }
        if (Validations.isEmpty(contactno)) {
            message += "Please Enter Some Value in Contact No Box\n";
            allvalid = false;
        } else if (!Validations.isValidContactNo(contactno)) {
            message += "Please Enter Valid Contact No\n";
            allvalid = false;
        }
        if (Validations.isEmpty(gender)) {
            message += "Please Choose Any Gender\n";
            allvalid = false;
        }
        if (Validations.isEmpty(maritalstatus)) {
            message += "Please Choose Any Marital Status\n";
            allvalid = false;
        }
        if (dob == null) {
            message += "Please Choose Any Valid Date of Birth\n";
            allvalid = false;
        }
        if (allvalid) {
            StudentsTO record = new StudentsTO();
            record.setStudentname(name);
            record.setFathername(fathername);
            record.setContactno(contactno);
            record.setGender(gender);
            record.setMaritalstatus(maritalstatus);
            record.setDob(dob);
            StudentsDAO action = new StudentsDAO();
            if (action.insertRecord(record)) {
                message = "Student Record is Added in System";
                if (image_path != null) {
                    int studentid = new CommonDAO().getLastInsertID();
                    if (studentid != 0) {
                        try {
                            StudentPhotosTO spt = new StudentPhotosTO();
                            spt.setStudentid(studentid);
                            spt.setPhotoname(CommonOperations.getFileName(image_path));
                            spt.setExtension(CommonOperations.getExtension(image_path));
                            spt.setPhotodata(new FileInputStream(image_path));
                            new StudentPhotosDAO().insertRecord(spt);
                            image_path = null;
                            ImageIcon icon = new ImageIcon(getClass().getResource("/pics/no_image.gif"));
                            lblPic.setIcon(icon);
                        } catch (Exception ex) {
                            ErrorHandler.showStackTrace(ex);
                        }
                    }
                }
            } else {
                message = "Insertion Failure Due To :: " + action.getError_message();
            }
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jtfContactNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfContactNoKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfContactNoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnSave;
    private controls.CurrentDatePanel cdpDob;
    private javax.swing.ButtonGroup groupGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox jcbMaritalStaus;
    private javax.swing.JRadioButton jrbFeMale;
    private javax.swing.JRadioButton jrbMale;
    private javax.swing.JRadioButton jrbOthers;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfFatherName;
    private javax.swing.JTextField jtfName;
    private javax.swing.JLabel lblPic;
    // End of variables declaration//GEN-END:variables
}
