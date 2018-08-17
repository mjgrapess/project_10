/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.adminscreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.dao.CoursesDAO;
import model.dao.StudentCoursesDAO;
import model.to.CoursesTO;
import model.to.StudentCoursesTO;
import operations.CommonOperations;

/**
 *
 * @author Grapess
 */
public class ViewStudentCourses extends javax.swing.JInternalFrame {

    List<StudentCoursesTO> student_courses;
    private JPopupMenu popup;
    private int scid;

    public ViewStudentCourses() {
        initComponents();
        bindTableDetails();
        preparePopupMenu();
        scid = 0;
    }

    public void bindTableDetails() {
        student_courses = new StudentCoursesDAO().getAllRecord();
        String[] col_names = {"Admission ID", "Student Name", "Course Name", "Course Fee", "Start Date", "End Date"};
        Object[][] records = null;
        if (student_courses != null && student_courses.size() > 0) {
            records = new Object[student_courses.size()][col_names.length];
            int index = 0;
            for (StudentCoursesTO sct : student_courses) {
                records[index] = new Object[col_names.length];
                records[index][0] = sct.getScid();
                records[index][1] = sct.getStudentname();
                records[index][2] = sct.getCoursename();
                records[index][3] = sct.getFee();
                records[index][4] = sct.getStart_date();
                records[index][5] = sct.getEnd_date() != null ? sct.getEnd_date() : " Not Ended ";
                index++;
            }
        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Record", "No Record", "No Record", "No Record", "No Record", "No Record"};
        }
        DefaultTableModel model = new DefaultTableModel(records, col_names) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tableStudentCourses.getTableHeader().setReorderingAllowed(false);
        tableStudentCourses.setAutoCreateRowSorter(true);
        tableStudentCourses.setModel(model);
    }

    private void preparePopupMenu() {
        popup = new JPopupMenu();
        JMenuItem delete_item = new JMenuItem("Delete This Record");
        JMenuItem edit_item = new JMenuItem("Edit This Record");
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/pics/delete.png"));
            delete_item.setIcon(icon);
        } catch (Exception ex) {
        }
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/pics/edit.png"));
            edit_item.setIcon(icon);
        } catch (Exception ex) {
        }
        popup.add(delete_item);
        popup.add(edit_item);
        delete_item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                delete_record();
            }
        });
        edit_item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                edit_record();
            }
        });
    }

    public void delete_record() {
        if (scid != 0 && student_courses != null) {
            int result = JOptionPane.showConfirmDialog(this, "Are You Sure To Removed This Record?", "Message From Admin", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                StudentCoursesDAO action = new StudentCoursesDAO();
                String message = "";
                if (action.deleteRecord(scid)) {
                    message = "Record is Removed From System Database";
                    bindTableDetails();
                } else {
                    message = "Deletion Failure Due To : " + action.getError_message();
                    if (message.contains("FOREIGN")) {
                        message = "This Record is Associated with other Records. So can not be deleted";
                    }
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        scid = 0;
    }

    public void edit_record() {
        if (scid != 0 && student_courses != null) {
            CommonOperations.showInternalFrame(getDesktopPane(), new AssignStudentCourse(scid));
            dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudentCourses = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Student Course Details");

        tableStudentCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableStudentCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentCoursesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStudentCourses);

        btnRefresh.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnRefresh.setText("Refresh Details");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        bindTableDetails();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableStudentCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentCoursesMouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            int row_point = tableStudentCourses.rowAtPoint(evt.getPoint());
            tableStudentCourses.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tableStudentCourses, evt.getX(), evt.getY());
            int row = tableStudentCourses.getSelectedRow();
            scid = Integer.parseInt(tableStudentCourses.getValueAt(row, 0).toString());
        }
    }//GEN-LAST:event_tableStudentCoursesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStudentCourses;
    // End of variables declaration//GEN-END:variables
}
