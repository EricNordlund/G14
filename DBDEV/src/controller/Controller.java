package controller;

import dal.DAL;
import java.sql.*;

public class Controller {

    DAL dal;
    long resTime;

    public Controller(DAL dl) throws SQLException {
        this.dal = dl;
    }

    public void insertStudent(String name, String adress) throws SQLException {
        responseTime(true);
        dal.insertStudent(name, adress);
        responseTime(false);
    }

    public void insertCourse(String name, String points, String semester) throws SQLException {
        responseTime(true);
        dal.addCourse(name, points, semester);
        responseTime(false);
    }

    public void deleteStudent(int studentID) throws SQLException {
        responseTime(true);
        dal.removeStudent(studentID);
        responseTime(false);
    }

    public void deleteCourse(int courseId) throws SQLException {
        responseTime(true);
        dal.removeCourse(courseId);
        responseTime(false);
    }

    public void setStudent(int studentID, String name, String adress) throws SQLException {
        responseTime(true);
        dal.modifyStudent(studentID, name, adress);
        responseTime(false);
    }

    public ResultSet getStudent(int studentID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getSingleStudent(studentID);
        responseTime(false);
        return rs;
    }

    public ResultSet getCourse(int courseId) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getCourse(courseId);
        responseTime(false);
        return rs;
    }

    public ResultSet findCourse(String searchString) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.findCourse(searchString);
        responseTime(false);
        return rs;
    }

    public ResultSet getAllCourses() throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getAllCourses();
        responseTime(false);
        return rs;
    }

    public ResultSet getReadingStudents(int courseID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getReadingStudents(courseID);
        responseTime(false);
        return rs;
    }

    public ResultSet getAllStudents() throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getAllStudents();
        responseTime(false);
        return rs;

    }

    public ResultSet getStudentResults(int studentID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getStudentResults(studentID);
        responseTime(false);
        return rs;
    }

    public ResultSet getStudentsOngoingCourses(int studentID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getStudentsOngoingCourses(studentID);
        responseTime(false);
        return rs;
    }

    public ResultSet getStudentsOngoingUngradedCourses(int studentID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getStudentsOngoingUngradedCourses(studentID);
        responseTime(false);
        return rs;
    }

    public ResultSet getStudentsOngoingPoints(int studentID, String semester) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getStudentsOngoingPoints(studentID, semester);
        responseTime(false);
        return rs;
    }

    public ResultSet searchStudentsCompletedCourses(int studentID, String courseSearch) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.searchStudentsCompletedCourses(studentID, courseSearch);
        responseTime(false);
        return rs;
    }

    public ResultSet getCoursePoints(int courseID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getCoursePoints(courseID);
        responseTime(false);
        return rs;
    }

    public ResultSet searchForStudent(String studentInfo) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.searchForStudent(studentInfo);
        responseTime(false);
        return rs;
    }

    public ResultSet getCourseResult(int courseID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getCourseResult(courseID);
        responseTime(false);
        return rs;
    }

    public ResultSet getCourseThroughput() throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getCourseThroughput();
        responseTime(false);
        return rs;
    }

    public ResultSet getPercentage5Students(int courseID) throws SQLException {
        responseTime(true);
        ResultSet rs = dal.getPercentageAStudents(courseID);
        responseTime(false);

        return rs;
    }

    public void addStudentReading(int studentID, int courseID) throws SQLException {
        responseTime(true);
        dal.addStudentReading(studentID, courseID);
        responseTime(false);
    }

    public void removeStudentReading(int studentID, int courseID) throws SQLException {
        responseTime(true);
        dal.removeStudentReading(studentID, courseID);
        responseTime(false);
    }

    public void removeStudentTotalReading(int studentID) throws SQLException {
        responseTime(true);
        dal.removeStudentTotalReading(studentID);
        responseTime(false);
    }

    public void addStudentRead(int studentID, int courseID, int grade) throws SQLException {
        responseTime(true);
        dal.addStudentRead(studentID, courseID, grade);
        responseTime(false);
    }

    public void removeStudentRead(int studentID, int courseID) throws SQLException {
        responseTime(true);
        dal.removeStudentRead(studentID, courseID);
        responseTime(false);

    }

    
    /**
     * Starts time if parameter input value is true
     * Ends time if parameter input value is false
     * @param start 
     */
    protected void responseTime(Boolean start) {
        long result = 0;

        if (start) {
            resTime = System.currentTimeMillis();

        } else if (start == false) {
            result = System.currentTimeMillis() - resTime;
            System.out.println("Response time: " + result + "ms");
        }

    }

}
