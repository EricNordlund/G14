/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.text.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Calendar;
import java.sql.*;
import java.util.Vector;
import javax.swing.JTextField;

/**
 *
 * @author Olle
 */
public class UMSFrame extends javax.swing.JFrame {

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;

    }

    /**
     * Creates new form testFrame
     */
    public UMSFrame() {
        initComponents();
        // Remove preset text in textfield on focus
        filterCoursesField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent fEvt) {
                JTextField tField = (JTextField) fEvt.getSource();
                tField.setText("");
            }
        });

        // Listen for selection changes in student table
        studentTable.getSelectionModel()
                .addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent event) {

                        try {
                            // Update reading and read tables
                            int viewRow = studentTable.getSelectedRow();
                            Object selValueObj = studentTable.getValueAt(viewRow, 0);
                            int selValue = (Integer) selValueObj;

                            ResultSet rsReading = controller.getStudentsOngoingUngradedCourses(selValue);
                            readingTable.setModel(rsToTableModel(rsReading));

                            ResultSet rsRead = controller.getStudentResults(selValue);
                            readTable.setModel(rsToTableModel(rsRead));
                        } catch (java.sql.SQLException e) {
                            e.printStackTrace();
                        } catch (ArrayIndexOutOfBoundsException e) {

                        }
                    }
                });

        // Listen for selection changes in course table
        courseTable.getSelectionModel()
                .addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent event) {

                        try {
                            // Update tables for current and past students
                            int viewRow = courseTable.getSelectedRow();
                            Object selValueObj = courseTable.getValueAt(viewRow, 0);
                            int selValue = (Integer) selValueObj;

                            ResultSet rsStudents = controller.getReadingStudents(selValue);
                            studentsInCourseTable.setModel(rsToTableModel(rsStudents));

                            ResultSet rsPastStudents = controller.getCourseResult(selValue);
                            pastStudentsInCourseTable.setModel(rsToTableModel(rsPastStudents));

                            // Get and display A grade students
                            ResultSet rsAStudentsPercent = controller.getPercentage5Students(selValue);
                            String arrAPercent = null;
                 
                                while (rsAStudentsPercent.next()) {
                                    String em = rsAStudentsPercent.getString("Percentage");
                                    arrAPercent = em.replace("\n", ",");
                                }
                            

                            System.out.println("arrAPercent: " + arrAPercent);
                            
                                double dAPercent = Double.parseDouble(arrAPercent);
                                DecimalFormat df = new DecimalFormat("##.###");
                                String aStudentsPercent = String.valueOf(df.format(dAPercent));

                                highestGradeStudentsLbl.setText("A grade students: " + aStudentsPercent + "%");
                            

                        } catch (java.sql.SQLException e) {
                            System.out.println("SQL-exception!");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("ArrayIndexOutOfBoundsException!");
                        } catch (Exception e) {
                            System.out.println("Exception!");
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
        addCourseDialog = new javax.swing.JDialog();
        courseNameLbl = new javax.swing.JLabel();
        courseNameField = new javax.swing.JTextField();
        coursePointsLbl = new javax.swing.JLabel();
        coursePointsField = new javax.swing.JTextField();
        semesterLbl = new javax.swing.JLabel();
        courseSemesterField = new javax.swing.JTextField();
        addCourseFinalBtn = new javax.swing.JButton();
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
        gradeStudentOnCourse = new javax.swing.JButton();
        markStudentSemesterDone = new javax.swing.JToggleButton();
        filterCoursesField = new javax.swing.JTextField();
        filterCoursesBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        getCourseBtn = new javax.swing.JButton();
        courseIdentField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        courseIDLabel = new javax.swing.JLabel();
        studentsInCourseLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        studentsInCourseTable = new javax.swing.JTable();
        getAllCoursesBtn = new javax.swing.JButton();
        addCourseBtn = new javax.swing.JButton();
        removeCourseBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        pastStudentsInCourseTable = new javax.swing.JTable();
        highestGradeStudentsLbl = new javax.swing.JLabel();
        getCourseThroughputsBtn = new javax.swing.JButton();

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

        addCourseDialog.setMinimumSize(new java.awt.Dimension(270, 300));

        courseNameLbl.setText("Course name:");

        coursePointsLbl.setText("Course points:");

        semesterLbl.setText("Semester (VT/HT):");

        addCourseFinalBtn.setText("Add");
        addCourseFinalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseFinalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addCourseDialogLayout = new javax.swing.GroupLayout(addCourseDialog.getContentPane());
        addCourseDialog.getContentPane().setLayout(addCourseDialogLayout);
        addCourseDialogLayout.setHorizontalGroup(
            addCourseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCourseDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(addCourseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCourseFinalBtn)
                    .addGroup(addCourseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(semesterLbl)
                        .addComponent(coursePointsLbl)
                        .addComponent(courseNameLbl)
                        .addComponent(courseNameField)
                        .addComponent(coursePointsField)
                        .addComponent(courseSemesterField, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        addCourseDialogLayout.setVerticalGroup(
            addCourseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCourseDialogLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(courseNameLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coursePointsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coursePointsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(semesterLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseSemesterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCourseFinalBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("University Management System");

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

        jLabel1.setText("Student ID/name/address:");

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

        jLabel6.setText("Completed courses");

        jLabel7.setText("Students");

        gradeStudentOnCourse.setText("Grade student on course");
        gradeStudentOnCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeStudentOnCourseActionPerformed(evt);
            }
        });

        markStudentSemesterDone.setText("Student done this semester");
        markStudentSemesterDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markStudentSemesterDoneActionPerformed(evt);
            }
        });

        filterCoursesField.setText("course ID/name");
        filterCoursesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCoursesFieldActionPerformed(evt);
            }
        });

        filterCoursesBtn.setText("Filter");
        filterCoursesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCoursesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getAllStudentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regStudentToCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(studentIdentField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(getSingleStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(markStudentSemesterDone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(unregStudentFrCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(gradeStudentOnCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(filterCoursesField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterCoursesBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addComponent(regStudentToCourseBtn)
                        .addGap(237, 237, 237)
                        .addComponent(markStudentSemesterDone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unregStudentFrCourseBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gradeStudentOnCourse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(filterCoursesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filterCoursesBtn)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student management", jPanel1);

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Name", "Points"
            }
        ));
        courseTable.setSize(new java.awt.Dimension(400, 60));
        jScrollPane4.setViewportView(courseTable);

        getCourseBtn.setText("Find");
        getCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCourseBtnActionPerformed(evt);
            }
        });

        jLabel11.setText("Courses");

        courseIDLabel.setText("Course ID/name/semester:");

        studentsInCourseLabel.setText("Current students in selected course");

        studentsInCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "StudentID", "Name"
            }
        ));
        jScrollPane5.setViewportView(studentsInCourseTable);

        getAllCoursesBtn.setText("Get all courses");
        getAllCoursesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllCoursesBtnActionPerformed(evt);
            }
        });

        addCourseBtn.setText("Add course");
        addCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseBtnActionPerformed(evt);
            }
        });

        removeCourseBtn.setText("Remove course");
        removeCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCourseBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Past students in selected course");

        pastStudentsInCourseTable.setModel(new javax.swing.table.DefaultTableModel(
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
        pastStudentsInCourseTable.setMaximumSize(new java.awt.Dimension(227, 64));
        jScrollPane6.setViewportView(pastStudentsInCourseTable);

        highestGradeStudentsLbl.setText("A grade students:");

        getCourseThroughputsBtn.setText("Get all course throughputs");
        getCourseThroughputsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCourseThroughputsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(highestGradeStudentsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(getAllCoursesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(getCourseThroughputsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(courseIdentField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(getCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(courseIDLabel)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(studentsInCourseLabel)
                            .addGap(0, 17, Short.MAX_VALUE))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(getAllCoursesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeCourseBtn)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getCourseThroughputsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(highestGradeStudentsLbl)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(studentsInCourseLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 267, Short.MAX_VALUE))
                                .addComponent(jScrollPane4)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(courseIDLabel)
                                .addComponent(jLabel11))
                            .addGap(2, 2, 2)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(courseIdentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(getCourseBtn))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Course management", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        String studentName = studentNameField.getText();
        String studentAddress = studentAddressField.getText();
        try {
            // If all information is entered, insert student
            if (!studentName.equals("") || !studentAddress.equals("")) {
                controller.insertStudent(studentName, studentAddress);

                // Update reading table
                ResultSet rs = controller.getAllStudents();
                studentTable.setModel(rsToTableModel(rs));
                
                addStudentDialog.dispose();
            // Else, display error message
            } else {
                JOptionPane.showMessageDialog(null, "You must enter values for all fields!", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (java.sql.SQLException e) {
            System.out.println("SQL exception!");
        }
    }//GEN-LAST:event_addStudentActionPerformed

    // Search for course (ID, name or address) and display results in table
    private void getCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCourseBtnActionPerformed
        try {
            String courseInfo = courseIdentField.getText();

            courseTable.getSelectionModel().clearSelection();
            ResultSet rs = controller.findCourse(courseInfo);
            courseTable.setModel(rsToTableModel(rs));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getCourseBtnActionPerformed

    // Grade student and add course to completed courses
    private void gradeStudentOnCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeStudentOnCourseActionPerformed
        try {
            // Get selected course
            int courseRowIndex = readingTable.getSelectedRow();
            Object selCourseIDObj = readingTable.getValueAt(courseRowIndex, 0);
            int selCourse = (Integer) selCourseIDObj;

            // Get selected student
            int studentRowIndex = studentTable.getSelectedRow();
            Object selStudentObj = studentTable.getValueAt(studentRowIndex, 0);
            int selStudent = (Integer) selStudentObj;

            // Display input dialog for grade and insert course into read table
            String grade = JOptionPane
                    .showInputDialog(null, "Enter grade for student " + selStudent + " in course " + selCourse, "Grade student", JOptionPane.PLAIN_MESSAGE);
            int intGrade = Integer.parseInt(grade);
            /*controller.removeStudentReading(selStudent, selCourse);*/
            controller.addStudentRead(selStudent, selCourse, intGrade);

            // Update reading table
            ResultSet rsReading = controller.getStudentsOngoingUngradedCourses(selStudent);
            readingTable.setModel(rsToTableModel(rsReading));

            // Update read table
            ResultSet rsRead = controller.getStudentResults(selStudent);
            readTable.setModel(rsToTableModel(rsRead));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            // Display error message
            JOptionPane.showMessageDialog(null, "Select a student & course first from the tables!", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Index out of bounds!");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_gradeStudentOnCourseActionPerformed

    // Unregister student from course in reading table
    private void unregStudentFrCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unregStudentFrCourseBtnActionPerformed
        try {
            // Get course ID
            int courseRowIndex = readingTable.getSelectedRow();
            Object selCourseIDObj = readingTable.getValueAt(courseRowIndex, 0);
            int selCourse = (Integer) selCourseIDObj;

            // Get student ID
            int studentRowIndex = studentTable.getSelectedRow();
            Object selStudentObj = studentTable.getValueAt(studentRowIndex, 0);
            int selStudent = (Integer) selStudentObj;

            // Remove from reading table
            controller.removeStudentReading(selStudent, selCourse);

            // Update reading table
            ResultSet rsReading = controller.getStudentsOngoingUngradedCourses(selStudent);
            readingTable.setModel(rsToTableModel(rsReading));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            // Display error messeage if nothing selected
            JOptionPane.showMessageDialog(null, "You must select a course for deletion in the students ongoing courses table.", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println("Index out of bounds!");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_unregStudentFrCourseBtnActionPerformed

    // Return corresponding semester from number
    private String NumberToSemester(int nr) {
        String semester = null;

        if ((nr >= 1) && (nr <= 6)) {
            semester = "HT";
        } else if ((nr >= 9) && (nr <= 12)) {
            semester = "VT";
        }

        return semester;
    }

    // Return current semester based on current date
    // and it's classification
    private String getSemester() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd.").format(Calendar.getInstance().getTime());
        String semester = null;
        String currentMonth = timeStamp.substring(5, 7);

        int nr = Integer.parseInt(currentMonth);
        semester = NumberToSemester(nr);

        return semester;
    }

    // Return an int from inputed resultset (for point values)
    private int rsToInt(ResultSet rSet, String column) {
        int returnInt = 0;

        try {
            String tempString = null;
            while (rSet.next()) {
                String em = rSet.getString(column);
                tempString = em.replace("\n", "");
                System.out.println(tempString);
            }

            returnInt = Integer.parseInt(tempString);

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return returnInt;

    }

    // Register student to course
    private void regStudentToCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regStudentToCourseBtnActionPerformed

        try {
            int rowIndex = studentTable.getSelectedRow();
            Object selValueObj = studentTable.getValueAt(rowIndex, 0);
            String selValue = selValueObj.toString();

            String courseCode = JOptionPane
                    .showInputDialog(null, "Enter course code for addition of student " + selValue + ":", "Register student to course", JOptionPane.PLAIN_MESSAGE);

            int intSelValue = Integer.parseInt(selValue);
            int intCourseCode = Integer.parseInt(courseCode);

            int studentPoints = 0;
            int coursePoints = 0;

            String semester = getSemester();
            System.out.println("semester: " + semester);

            try {
                ResultSet rsPoints = controller.getStudentsOngoingPoints(intSelValue, semester);
                studentPoints = rsToInt(rsPoints, "Points");
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("NullPointerException!");
            }

            try {
                ResultSet rsCoursePoints = controller.getCoursePoints(intCourseCode);
                coursePoints = rsToInt(rsCoursePoints, "Points");
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("NullPointerException!");
            }

            // For 45 hp limit per semester
            if (studentPoints > (45 - coursePoints)) {
                JOptionPane.showMessageDialog(null, "You cannot register for more than 45hp/semester", "Error", JOptionPane.PLAIN_MESSAGE);
            } else {
                try {
                    controller.addStudentReading(intSelValue, intCourseCode);

                    // Update reading table
                    ResultSet rs = controller.getStudentsOngoingUngradedCourses(intSelValue);
                    readingTable.setModel(rsToTableModel(rs));

                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }  catch (NullPointerException e) {
                    System.out.println("NullPointerException!");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("This is not a number!");
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Select a student first from the table!", "Error", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_regStudentToCourseBtnActionPerformed

    // Remove a student (with safety measure)
    private void removeStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStudentBtnActionPerformed

        String removedStudent = JOptionPane
                .showInputDialog(null, "Enter student ID for student REMOVAL (safety measure):", "Remove student", JOptionPane.PLAIN_MESSAGE);
        try {
            int intRemovedStudent = Integer.parseInt(removedStudent);
            controller.deleteStudent(intRemovedStudent);

            // Update reading table
            ResultSet rs = controller.getAllStudents();
            studentTable.setModel(rsToTableModel(rs));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No values entered!", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_removeStudentBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        addStudentDialog.setVisible(true);
    }//GEN-LAST:event_addStudentBtnActionPerformed

    // Search for a specific student and return result in students table
    private void getSingleStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSingleStudentBtnActionPerformed

        try {
            String studentInfo = studentIdentField.getText();

            studentTable.getSelectionModel().clearSelection();
            ResultSet rs = controller.searchForStudent(studentInfo);
            studentTable.setModel(rsToTableModel(rs));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getSingleStudentBtnActionPerformed

    // Display all students in students table
    private void getAllStudentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllStudentsBtnActionPerformed

        try {
            studentTable.getSelectionModel().clearSelection();
            ResultSet rs = controller.getAllStudents();

            studentTable.setModel(rsToTableModel(rs));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getAllStudentsBtnActionPerformed

    // Display all courses in courses table
    private void getAllCoursesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllCoursesBtnActionPerformed
        try {

            ResultSet rs = controller.getAllCourses();
            courseTable.setModel(rsToTableModel(rs));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getAllCoursesBtnActionPerformed

    // Display course addition dialog
    private void addCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseBtnActionPerformed
        addCourseDialog.setVisible(true);
    }//GEN-LAST:event_addCourseBtnActionPerformed

    // Add course
    private void addCourseFinalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseFinalBtnActionPerformed
        try {
            String courseName = courseNameField.getText();
            String coursePoints = coursePointsField.getText();
            String courseSemester = courseSemesterField.getText();

            if (!courseName.equals("") || !coursePoints.equals("") || !courseSemester.equals("")) {
                controller.insertCourse(courseName, coursePoints, courseSemester);
                
                // Update course table
                ResultSet rsCourse = controller.getAllCourses();
                courseTable.setModel(rsToTableModel(rsCourse));

                addCourseDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "You must enter values for all fields!", "Error", JOptionPane.PLAIN_MESSAGE);
            }


        } catch (java.sql.SQLException e) {
            System.out.println("SQLException!");
        }
    }//GEN-LAST:event_addCourseFinalBtnActionPerformed

    // Remove a course (with safety measure)
    private void removeCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCourseBtnActionPerformed
        String courseToRemove = JOptionPane
                .showInputDialog(null, "Enter course ID for course REMOVAL (safety measure):", "Remove course", JOptionPane.PLAIN_MESSAGE);
        try {
            int intCourseToRemove = Integer.parseInt(courseToRemove);
            controller.deleteCourse(intCourseToRemove);

            // Update course table
            courseTable.getSelectionModel().clearSelection();
            ResultSet rsCourse = controller.getAllCourses();
            courseTable.setModel(rsToTableModel(rsCourse));

        } catch (java.sql.SQLException e) {
            System.out.println("SQLException!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException!");
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No value entered!", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_removeCourseBtnActionPerformed

    // Display complete courses throughput in the courses table
    private void getCourseThroughputsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getCourseThroughputsBtnActionPerformed
        try {
            courseTable.getSelectionModel().clearSelection();
            ResultSet rs = controller.getCourseThroughput();

            courseTable.setModel(rsToTableModel(rs));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_getCourseThroughputsBtnActionPerformed

    // Empty the reading table for a student
    private void markStudentSemesterDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markStudentSemesterDoneActionPerformed
        try {
            int rowIndex = studentTable.getSelectedRow();
            Object selValueObj = studentTable.getValueAt(rowIndex, 0);

            int studentID = (Integer) selValueObj;
            controller.removeStudentTotalReading(studentID);
            
            ResultSet rs = controller.getStudentsOngoingUngradedCourses(studentID);
            readingTable.setModel(rsToTableModel(rs));
            
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Select a student first from the student table!", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_markStudentSemesterDoneActionPerformed

    private void filterCoursesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCoursesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterCoursesFieldActionPerformed

    // Search a students completed courses
    private void filterCoursesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCoursesBtnActionPerformed
        try {
            int rowIndex = studentTable.getSelectedRow();
            Object selValueObj = studentTable.getValueAt(rowIndex, 0);
            int studentID = (Integer) selValueObj;

            readTable.getSelectionModel().clearSelection();
            String searchString = filterCoursesField.getText();

            ResultSet rs = controller.searchStudentsCompletedCourses(studentID, searchString);

            readTable.setModel(rsToTableModel(rs));

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_filterCoursesBtnActionPerformed

    // Return TableModel from ResultSet
    public static TableModel rsToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int nrOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            int column = 0;
            
            // Gets all column names
            while (column < nrOfColumns) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
                column++;
            }

            // Gets all rows
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();
                
                column = 1;
                while (column <= nrOfColumns) {
                    newRow.addElement(rs.getObject(column));
                    column++;
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (SQLException e) {
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
            java.util.logging.Logger.getLogger(UMSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UMSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UMSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UMSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UMSFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseBtn;
    private javax.swing.JDialog addCourseDialog;
    private javax.swing.JButton addCourseFinalBtn;
    private javax.swing.JButton addStudent;
    private javax.swing.JButton addStudentBtn;
    private javax.swing.JDialog addStudentDialog;
    private javax.swing.JLabel courseIDLabel;
    private javax.swing.JTextField courseIdentField;
    private javax.swing.JTextField courseNameField;
    private javax.swing.JLabel courseNameLbl;
    private javax.swing.JTextField coursePointsField;
    private javax.swing.JLabel coursePointsLbl;
    private javax.swing.JTextField courseSemesterField;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton filterCoursesBtn;
    private javax.swing.JTextField filterCoursesField;
    private javax.swing.JButton getAllCoursesBtn;
    private javax.swing.JButton getAllStudentsBtn;
    private javax.swing.JButton getCourseBtn;
    private javax.swing.JButton getCourseThroughputsBtn;
    private javax.swing.JButton getSingleStudentBtn;
    private javax.swing.JButton gradeStudentOnCourse;
    private javax.swing.JLabel highestGradeStudentsLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton markStudentSemesterDone;
    private javax.swing.JTable pastStudentsInCourseTable;
    private javax.swing.JTable readTable;
    private javax.swing.JTable readingTable;
    private javax.swing.JButton regStudentToCourseBtn;
    private javax.swing.JButton removeCourseBtn;
    private javax.swing.JButton removeStudentBtn;
    private javax.swing.JLabel semesterLbl;
    private javax.swing.JTextField studentAddressField;
    private javax.swing.JTextField studentIdentField;
    private javax.swing.JTextField studentNameField;
    private javax.swing.JTable studentTable;
    private javax.swing.JLabel studentsInCourseLabel;
    private javax.swing.JTable studentsInCourseTable;
    private javax.swing.JButton unregStudentFrCourseBtn;
    // End of variables declaration//GEN-END:variables
}
