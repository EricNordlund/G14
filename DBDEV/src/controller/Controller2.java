package controller;

import dal.Dal;
import java.sql.*;

public class Controller2 {
    Dal dal;

    public Controller2(Dal dl) throws SQLException 
    {
         this.dal = dl;
    }
    
    public void insertStudent(String name, String adress) throws SQLException {
        dal.insertStudent(name, adress);
    }
 
    public void insertCourse(String name, String points, String semester) throws SQLException {
        dal.addCourse(name, points, semester);
    }
    
    public void deleteStudent(int studentID) throws SQLException {
        dal.removeStudent(studentID);
    }
    
    public void deleteCourse(int courseId) throws SQLException {
        dal.removeCourse(courseId);
    }
    /*
    public void setCourse(String courseID, String name, String points) throws SQLException {
        dal.setCourse(courseID, points, name);
    }*/
    
    public void setStudent(int studentID, String name, String adress) throws SQLException {
        dal.modifyStudent(studentID, name, adress);
    }
    
    public ResultSet getStudent(int studentID) throws SQLException {

        ResultSet rs = dal.getSingleStudent(studentID);
        return rs;
    }
    
    public ResultSet getCourse(int courseId) throws SQLException {

        ResultSet rs = dal.getCourse(courseId);
        return rs;
    }
    
    public ResultSet findCourse(String searchString) throws SQLException {

        ResultSet rs = dal.findCourse(searchString);
        return rs;
    }
    
    public ResultSet getAllCourses() throws SQLException {

        ResultSet rs = dal.getAllCourses();
        return rs;
    }
    
    public ResultSet getReadingStudents(int courseID) throws SQLException {

        ResultSet rs = dal.getReadingStudents(courseID);
        return rs;
    }
    
    public ResultSet getAllStudents() throws SQLException
    {
        ResultSet rs = dal.getAllStudents();
        return rs;
        
    }
    
     public ResultSet getStudentResults(int studentID) throws SQLException {

        ResultSet rs = dal.getStudentResults(studentID);
        return rs;
    }
     
    public ResultSet getStudentsOngoingCourses(int studentID) throws SQLException {

        ResultSet rs = dal.getStudentsOngoingCourses(studentID);
        return rs;
    }
    
    public ResultSet getStudentsOngoingUngradedCourses(int studentID) throws SQLException {

        ResultSet rs = dal.getStudentsOngoingUngradedCourses(studentID);
        return rs;
    }
    
    public ResultSet getStudentsOngoingPoints(int studentID, String semester) throws SQLException {

        ResultSet rs = dal.getStudentsOngoingPoints(studentID, semester);
        return rs;
    }
    
    public ResultSet getCoursePoints(int courseID) throws SQLException {

        ResultSet rs = dal.getCoursePoints(courseID);
        return rs;
    }
    
    public ResultSet searchForStudent(String studentInfo) throws SQLException {

        ResultSet rs = dal.searchForStudent(studentInfo);
        return rs;
    }
    
    public ResultSet getCourseResult(int courseID) throws SQLException {

        ResultSet rs = dal.getCourseResult(courseID);
        return rs;
    }
    
    public ResultSet getCourseThroughput() throws SQLException {

        ResultSet rs = dal.getCourseThroughput();
        return rs;
    }
    
    public ResultSet getPercentage5Students(int courseID) throws SQLException {

        ResultSet rs = dal.getPercentageAStudents(courseID);
        
        
        return rs;
    }
    
    public void addStudentReading(int studentID, int courseID ) throws SQLException {
        dal.addStudentReading(studentID, courseID);
    }
    
    public void removeStudentReading(int studentID, int courseID) throws SQLException {
        dal.removeStudentReading(studentID, courseID);
    }
    
    public void removeStudentTotalReading(int studentID) throws SQLException {
        dal.removeStudentTotalReading(studentID);
    }
    
     public void addStudentRead(int studentID, int courseID, int grade) throws SQLException {
         dal.addStudentRead(studentID, courseID, grade);
    }
    
    public void removeStudentRead(int studentID, int courseID) throws SQLException {
        dal.removeStudentRead(studentID, courseID);
    
    }
    
}
