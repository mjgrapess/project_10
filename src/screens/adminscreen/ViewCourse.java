/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.adminscreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.CoursesDAO;
import model.to.CoursesTO;
import operations.CommonOperations;

/**
 *
 * @author Grapess
 */
public class ViewCourse extends javax.swing.JInternalFrame {

    private List<CoursesTO> courses;
    private JPopupMenu popup;
    private int srow;

    public ViewCourse() {
        initComponents();
        bindTableDetails();
        preparePopupMenu();
        srow = -1;
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
        if (srow != -1 && courses != null && srow < courses.size()) {
            CoursesTO record = courses.get(srow);
            if (record != null) {
                int result = JOptionPane.showConfirmDialog(this, "Are You Sure To Removed This Record?", "Message From Admin", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    CoursesDAO action = new  CoursesDAO();
                    String message = "";
                    if(action.deleteRecord(record.getCourseid())){
                        message = "Record is Removed From System Database";
                        bindTableDetails();
                    }else{
                        message = "Deletion Failure Due To : " + action.getError_message();
                        if(message.contains("FOREIGN")){
                            message = "This Record is Associated with other Records. So can not be deleted";
                        }
                    }
                    JOptionPane.showMessageDialog(this, message);
                }
            }
        }
        srow = -1;
    }
    public void edit_record() {
        if (srow != -1 && courses != null && srow < courses.size()) {
            CoursesTO record = courses.get(srow);
            if(record!=null){
                CommonOperations.showInternalFrame(getDesktopPane(), new AddNewCourse(record));
                dispose();
            }
        }
        srow = -1;
    }

    public void bindTableDetails() {
        courses = new CoursesDAO().getAllRecord();
        String[] col_names = {"Course ID", "Course Name", "Course Fee"};
        Object[][] records = null;
        if (courses != null && courses.size() > 0) {
            records = new Object[courses.size()][col_names.length];
            int index = 0;
            for (CoursesTO ct : courses) {
                records[index] = new Object[]{ct.getCourseid(), ct.getCoursename(), ct.getCoursefee()};
                index++;
            }
        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Record", "No Record", "No Record"};
        }
        DefaultTableModel model
                = new DefaultTableModel(records, col_names) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
        tableCourse.setModel(model);
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
        tableCourse = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("All Course Details");
        setToolTipText("");

        tableCourse.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCourse);

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        bindTableDetails();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tableCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCourseMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            //System.out.println("Right Clicked");
            int row_point = tableCourse.rowAtPoint(evt.getPoint());
            tableCourse.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tableCourse, evt.getX(), evt.getY());
            // System.out.println(tableCourse.getSelectedRow());
            srow = tableCourse.getSelectedRow();
        }
    }//GEN-LAST:event_tableCourseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCourse;
    // End of variables declaration//GEN-END:variables
}
