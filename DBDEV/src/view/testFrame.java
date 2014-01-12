/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;
import controller.Controller2;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Olle
 */
public class testFrame extends javax.swing.JFrame {

    private Controller2 controller; // Koppling till klassen Controller
    public void setController(Controller2 controller){
        this.controller = controller;
        
    }
    
    /**
     * Creates new form testFrame
     */
    public testFrame() {
        initComponents();
        studentTable.getSelectionModel()
                .addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int viewRow = studentTable.getSelectedRow();
                Object selValueObj = studentTable.getValueAt(viewRow, 0);
                int selValue = (Integer)selValueObj;
                System.out.println("value changed!"+selValue);
        
        try  {
            DefaultTableModel readingModel = (DefaultTableModel) readingTable.getModel();
            ResultSet rsReading = controller.getStudentsOngoingCourses(selValue); 
            readingTable.setModel(resultSetToTableModel(rsReading));
            
            DefaultTableModel readModel = (DefaultTableModel) readTable.getModel();
            ResultSet rsRead = controller.getStudentResults(selValue);
            readTable.setModel(resultSetToTableModel(rsRead));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
            } 
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addStudentDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        studentNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        studentAddressField = new javax.swing.JTextField();
        addStudent = new javax.swing.JButton();
        regStudentToCourseDialog = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        getAllStudentsBtn = new javax.swing.JButton();
        getSingleStudentBtn = new javax.swing.JButton();
        studentIdentField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addStudentBtn = new javax.swing.JButton();
        removeStudentBtn = new javax.swing.JButton();
        regStudentToCourseBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        readingTable = new javax.swing.JTable();
        unregStudentFrCourseBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        readTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        addStudentDialog.setTitle("Add student");
        addStudentDialog.setMinimumSize(new java.awt.Dimension(230, 230));

        jLabel2.setText("Name:");

        jLabel3.setText("Address:");

        addStudent.setText("Add");
        addStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addStudentDialogLayout = new javax.swing.GroupLayout(addStudentDialog.getContentPane());
        addStudentDialog.getContentPane().setLayout(addStudentDialogLayout);
        addStudentDialogLayout.setHorizontalGroup(
            addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentDialogLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudent)
                    .addGroup(addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(studentNameField)
                        .addComponent(studentAddressField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        addStudentDialogLayout.setVerticalGroup(
            addStudentDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentDialogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addStudent)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout regStudentToCourseDialogLayout = new javax.swing.GroupLayout(regStudentToCourseDialog.getContentPane());
        regStudentToCourseDialog.getContentPane().setLayout(regStudentToCourseDialogLayout);
        regStudentToCourseDialogLayout.setHorizontalGroup(
            regStudentToCourseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regStudentToCourseDialogLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel4)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        regStudentToCourseDialogLayout.setVerticalGroup(
            regStudentToCourseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regStudentToCourseDialogLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel4)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Address"
            }
        ));
        studentTable.setSize(new java.awt.Dimension(400, 60));
        jScrollPane1.setViewportView(studentTable);

        getAllStudentsBtn.setText("Get all students");
        getAllStudentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllStudentsBtnActionPerformed(evt);
            }
        });

        getSingleStudentBtn.setText("Find");
        getSingleStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getSingleStudentBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Student ID:");

        addStudentBtn.setText("Add student");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });

        removeStudentBtn.setText("Remove student");
        removeStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentBtnActionPerformed(evt);
            }
        });

        regStudentToCourseBtn.setText("Register student to course");
        regStudentToCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regStudentToCourseBtnActionPerformed(evt);
            }
        });

        readingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CourseID", "Name"
            }
        ));
        jScrollPane2.setViewportView(readingTable);

        unregStudentFrCourseBtn.setText("Unregister student from course");
        unregStudentFrCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unregStudentFrCourseBtnActionPerformed(evt);
            }
        });

        readTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CourseID", "Name", "Grade"
            }
        ));
        jScrollPane3.setViewportView(readTable);

        jLabel5.setText("Ongoing courses");

        jLabel6.setText("Finished courses");

        jLabel7.setText("Students");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(getAllStudentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regStudentToCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentIdentField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(getSingleStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(unregStudentFrCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentIdentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getSingleStudentBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getAllStudentsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addStudentBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeStudentBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regStudentToCourseBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unregStudentFrCourseBtn)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))))
        );

        jTabbedPane1.addTab("Students", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    

    
    private void getAllStudentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllStudentsBtnActionPerformed
        // Append a row 
        DefaultTableModel studentModel = (DefaultTableModel) studentTable.getModel();
        try  {
            ResultSet rs = controller.getAllStudents();
       /*if(rs.next()) {
        studentModel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
        } */
            studentTable.setModel(resultSetToTableModel(rs));
            /*studentModel.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});*/
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getAllStudentsBtnActionPerformed

    private void getSingleStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSingleStudentBtnActionPerformed
        DefaultTableModel studentModel = (DefaultTableModel) studentTable.getModel();    
        try {
            String studentID = studentIdentField.getText();
            int intStudentID = Integer.parseInt(studentID);
            ResultSet rs = controller.getStudent(intStudentID);
       if(rs.next()) {
            studentModel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
       } 
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getSingleStudentBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        addStudentDialog.setVisible(true);
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        String studentName = studentNameField.getText();
        String studentAddress = studentAddressField.getText();
        try {
            controller.insertStudent(studentName, studentAddress);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addStudentActionPerformed

    private void removeStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStudentBtnActionPerformed

        String removedStudent = JOptionPane
                .showInputDialog(null, "Enter student ID for student REMOVAL (safety measure):", "Remove student", JOptionPane.PLAIN_MESSAGE); 
        try {
            int intRemovedStudent = Integer.parseInt(removedStudent);
            controller.deleteStudent(intRemovedStudent);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("This is not a number!");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_removeStudentBtnActionPerformed

    private void regStudentToCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regStudentToCourseBtnActionPerformed
            
        try {
            int rowIndex = studentTable.getSelectedRow();
            int colIndex = studentTable.getSelectedColumn();
            Object selValueObj = studentTable.getValueAt(rowIndex, 0);
            String selValue = selValueObj.toString();
            System.out.println(selValue);
            
            String courseCode = JOptionPane
                .showInputDialog(null, "Enter course code for addition of student "+selValue+":", "Register student to course", JOptionPane.PLAIN_MESSAGE); 
            
            int intSelValue = Integer.parseInt(selValue);
            int intCourseCode = Integer.parseInt(courseCode);
            controller.addStudentReading(intSelValue, intCourseCode);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("This is not a number!");
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Select a student first from the table!", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Index out of bounds!");
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_regStudentToCourseBtnActionPerformed

    private void unregStudentFrCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unregStudentFrCourseBtnActionPerformed
        try {
            int courseRowIndex = readingTable.getSelectedRow();
            Object selCourseIDObj = readingTable.getValueAt(courseRowIndex, 0);
            int selCourse = (Integer)selCourseIDObj;
            
            int studentRowIndex = studentTable.getSelectedRow();
            Object selStudentObj = studentTable.getValueAt(studentRowIndex, 0);
            int selStudent = (Integer)selStudentObj;

            controller.removeStudentReading(selStudent, selCourse);
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "You must select a course for deletion in the students courses list.", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Index out of bounds!");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_unregStudentFrCourseBtnActionPerformed

    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

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
            java.util.logging.Logger.getLogger(testFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*studentTable.setModel(tableModel);*/
        

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudent;
    private javax.swing.JButton addStudentBtn;
    private javax.swing.JDialog addStudentDialog;
    private javax.swing.JButton getAllStudentsBtn;
    private javax.swing.JButton getSingleStudentBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable readTable;
    private javax.swing.JTable readingTable;
    private javax.swing.JButton regStudentToCourseBtn;
    private javax.swing.JDialog regStudentToCourseDialog;
    private javax.swing.JButton removeStudentBtn;
    private javax.swing.JTextField studentAddressField;
    private javax.swing.JTextField studentIdentField;
    private javax.swing.JTextField studentNameField;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton unregStudentFrCourseBtn;
    // End of variables declaration//GEN-END:variables
}
