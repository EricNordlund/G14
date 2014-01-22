package dal;

import java.sql.*;

/**
 *
 * @author Eric, Olle, Bjorn
 * 
 * DB connection can easily be modified
 * to work with both MSSQL and MySQL
 */
public class DAL {

    private Connection con = null;
    private Statement statement;

    /*
     * DATABASE CONNECTION METHODS
     * 
     */
    
    /**
     * Initiates a connection against server
     * and loads drivers and creates a statement
     * @throws SQLException
     */
    public DAL() throws SQLException {
        DAL.loadDriver();
        this.con = DAL.openConnection();
        this.statement = con.createStatement();
    }

    /**
     * Loads drivers to connec to a database with JDBC 4.0
     */
    private static void loadDriver() {

        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("SQL-driver loaded");
        } catch (Exception errorMessage) {

            System.out.println("Driver manager error: " + errorMessage);

        }
    }

    /**
     * Opens connection to SQL server with JDBC 4.0
     * @return En SQL-Anslutning
     * @throws SQLException
     */
    private static Connection openConnection() throws SQLException {

        String serverURL = "jdbc:mysql://localhost:8889/dbproject";
        String serverLogon = "root";
        String serverPassword = "root";

        Connection sqlConnection = DriverManager.getConnection(serverURL, serverLogon, serverPassword);
        System.out.println("Connection opened");

        return sqlConnection;
    }

    public void sendQuery(String query) throws SQLException {

        statement.executeUpdate(query);

    }

    public ResultSet getQuery(String query) throws SQLException {

        ResultSet result = statement.executeQuery(query);
        return result;
    }

    /**
     * Close connection to the SQL server.
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {

        this.con.close();

    }

    /**
     * Returns true if String contains numbers
     * @param str
     * @return 
     */
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * DATABASE QUERIES
     */
    
    /**
     * Returns a resultset with all students
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet getAllStudents() throws SQLException {
        String query = "SELECT studentID StudentID, name Name, adress Adress FROM student";
        ResultSet result = getQuery(query);
        System.out.println("Getting student list.");
        return result;
    }

    /**
     * Returns all personal student information from a single student.
     * @param studentID ID på den student som är av intresse.
     * @return Samtliga data i form av ett resultset.
     * @throws SQLException
     */
    public ResultSet getSingleStudent(int studentID) throws SQLException {
        String query = "SELECT * FROM student WHERE studentID='" + studentID + "'";
        ResultSet result = getQuery(query);
        System.out.println("getSingleStudent done");
        return result;

    }

    /**
     *  Updates information for single student
     * @param studentID
     * @param name
     * @param adress
     * @throws SQLException 
     */
    public void modifyStudent(int studentID, String name, String adress) throws SQLException {
        String query = "UPDATE student SET name='" + name + "', adress='" + adress + "' WHERE studentID='" + studentID + "'";
        sendQuery(query);
        System.out.println("Updated student " + studentID + ".");
    }

    /**
     *  Inserts student in table student
     * @param name
     * @param adress
     * @throws SQLException 
     */
    public void insertStudent(String name, String adress) throws SQLException {
        String query = "INSERT INTO student (name, adress) VALUES('" + name + "', '" + adress + "')";
        sendQuery(query);
        System.out.println("Registered new student.");
    }

    /**
     *  Removes student from student table
     * @param studentID
     * @throws SQLException 
     */
    public void removeStudent(int studentID) throws SQLException {
        String query = "DELETE FROM student WHERE studentID = " + studentID;
        sendQuery(query);
        System.out.println("Removed student " + studentID + ".");
    }

    /**
     * Searches for specific student (ID, name, address)
     * @param searchString
     * @return
     * @throws SQLException 
     */
    public ResultSet searchForStudent(String searchString) throws SQLException {
        String query;

        if (isNumeric(searchString)) {
            query = "SELECT * FROM student WHERE studentID='" + searchString + "'";
        } else {
            query = "SELECT * FROM student WHERE name LIKE '%" + searchString + "%' OR adress LIKE '%" + searchString + "%'";
        }

        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * READING QUERIES
     */
    
    /**
     *  Adds course to students reading courses
     * @param studentID
     * @param courseID
     * @throws SQLException 
     */
    public void addStudentReading(int studentID, int courseID) throws SQLException {
        String query = "INSERT INTO reading (studentID, courseID) VALUES('" + studentID + "', '" + courseID + "')";
        sendQuery(query);
        System.out.println("Added student to course.");
    }

    /**
     *  Removes course from students reading courses
     * @param studentID
     * @param courseID
     * @throws SQLException 
     */
    public void removeStudentReading(int studentID, int courseID) throws SQLException {
        String query = "DELETE FROM reading WHERE studentID = '" + studentID + "' AND courseID = '" + courseID + "'";
        sendQuery(query);
        System.out.println("Removed student from course.");
    }

    /**
     * Removes all courses from students reading courses
     * @param studentID
     * @throws SQLException 
     */
    public void removeStudentTotalReading(int studentID) throws SQLException {
        String query = "DELETE FROM reading WHERE studentID = '" + studentID + "'";
        sendQuery(query);
        System.out.println("Removed student from courses.");
    }

    /**
     * READING QUERIES
     */
    
    /**
     * Adds course to students completed courses (read)
     * @param studentID
     * @param courseID
     * @param grade
     * @throws SQLException 
     */
    public void addStudentRead(int studentID, int courseID, int grade) throws SQLException {
        /*String query = "DELETE FROM reading WHERE studentID = '" + studentID +"' AND courseID = '" + courseID +"'";
         sendQuery(query);*/

        String query = "INSERT INTO haveRead (studentID, courseID, grade) VALUES('" + studentID + "', '" + courseID + "', '" + grade + "')";
        sendQuery(query);

        System.out.println("Ended course for student.");
    }

    /**
     * Removes course from students completed courses (read)
     * @param studentID
     * @param courseID
     * @throws SQLException 
     */
    public void removeStudentRead(int studentID, int courseID) throws SQLException {
        String query = "DELETE FROM reading WHERE studentID = '" + studentID + "' AND courseID = '" + courseID + "'";
        sendQuery(query);
        System.out.println("Ended course for student.");

    }

    /**
     * COURSE QUERIES
     * /

    /**
     * Removes course
     *
     * @param courseId
     * @throws SQLException
     */
    public void removeCourse(int courseId) throws SQLException {
        String query = "DELETE FROM course WHERE courseId = " + courseId;
        sendQuery(query);
        System.out.println("Removed course: " + courseId);
    }

    /**
     * Returns all courses
     * @return
     * @throws SQLException 
     */
    public ResultSet getAllCourses() throws SQLException {
        String query = "SELECT courseID CourseID, name Name, points Points, semester Semester FROM course";
        ResultSet result = getQuery(query);
        System.out.println("Got course list.");
        return result;
    }

    /**
     * Returns course information from a course ID
     * @param courseId
     * @throws SQLException
     */
    public ResultSet getCourse(int courseId) throws SQLException {
        String query = "SELECT courseID CourseID, name Name, points Points, semester Semester FROM course WHERE courseId = " + courseId;
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Searches for course ID, name or semester and returns matching courses
     * @param searchString
     * @return
     * @throws SQLException 
     */
    public ResultSet findCourse(String searchString) throws SQLException {
        String query;

        if (isNumeric(searchString)) {
            query = "SELECT * FROM course WHERE courseID='" + searchString + "'";
        } else {
            query = "SELECT * FROM course WHERE name LIKE '%" + searchString + "%' OR semester LIKE '%" + searchString + "%'";
        }

        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Adds course to course table
     * @param courseName
     * @param coursePoints
     * @throws SQLException
     */
    public void addCourse(String courseName,
            String coursePoints, String courseSemester) throws SQLException {
        String query = "INSERT INTO course (name, points, semester) VALUES ('" + courseName + "','" + coursePoints + "','" + courseSemester + "')";
        sendQuery(query);

        System.out.println("Registered new course: " + courseName);
    }

    /**
     * Returns results for course
     * @param courseId
     * @throws SQLException
     */
    public ResultSet getCourseResult(int courseID) throws SQLException {
        String query = "SELECT st.studentID StudentID ,st.name Name, rd.grade Grade FROM student st INNER JOIN (SELECT studentID, grade FROM haveRead WHERE courseID = '" + courseID + "') AS rd ON st.studentID = rd.studentID";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns reading students for a course
     * @param courseID
     * @return
     * @throws SQLException 
     */
    public ResultSet getReadingStudents(int courseID) throws SQLException {
        String query = "SELECT st.studentID StudentID, st.name Name FROM student st INNER JOIN (SELECT studentID FROM reading WHERE courseID = '" + courseID + "') AS rd ON st.studentID = rd.studentID";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns every student that recieved A in a course
     * @param courseID
     * @return
     * @throws SQLException
     */
    public ResultSet getAStudents(int courseID) throws SQLException {
        String query = "SELECT st.studentID StudentID, st.name Name FROM student st INNER JOIN (SELECT studentID FROM haveRead WHERE courseID = '" + courseID + "' AND grade = '6') AS rd ON st.studentID = rd.studentID";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns percent of students with A grade in a course
     * @param courseID
     * @return 
     * @throws SQLException
     */
    public ResultSet getPercentageAStudents(int courseID) throws SQLException {
        String query = "SELECT (SELECT count(studentID) FROM haveRead WHERE courseID = '" + courseID + "' AND grade = '5') * 100 / (SELECT count(studentID) FROM haveRead WHERE courseID = '" + courseID + "') AS Percentage";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns courses with the highest throughputs
     * @return
     * @throws SQLException
     */
    public ResultSet getCourseThroughput() throws SQLException {
        String query = "SELECT courseID CourseID, count(studentID) Students FROM (SELECT * FROM haveRead WHERE grade > 0) AS CD GROUP BY courseID ORDER BY Students DESC";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns students graded/completed courses
     * @param studentID
     * @return
     * @throws SQLException
     */
    public ResultSet getStudentResults(int studentID) throws SQLException {
        String query = "SELECT cr.courseID CourseID, cr.name Name, grade Grade FROM course cr INNER JOIN (SELECT courseID, grade FROM haveRead WHERE studentID = '" + studentID + "') AS rd ON cr.courseID = rd.courseID";
        ResultSet result = getQuery(query);
        return result;
    }
    
    /**
     * Searches for courses in a students completed courses
     * @param studentID
     * @param courseSearch
     * @return
     * @throws SQLException 
     */
    public ResultSet searchStudentsCompletedCourses(int studentID, String courseSearch) throws SQLException {
        String query = "SELECT cr.courseID CourseID, cr.name Name, grade Grade FROM course cr INNER JOIN (SELECT courseID, grade FROM haveRead WHERE studentID = '" + studentID + "') AS rd ON cr.courseID = rd.courseID WHERE (cr.courseID='" + courseSearch + "' OR cr.name LIKE '%" + courseSearch + "%')";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns a students ongoing courses
     * @param studentID
     * @return
     * @throws SQLException 
     */
    public ResultSet getStudentsOngoingCourses(int studentID) throws SQLException {
        String query = "SELECT cr.courseID CourseID, cr.name Name, cr.points Points FROM course cr INNER JOIN (SELECT courseID, studentID FROM reading WHERE studentID = '" + studentID + "') AS rd ON cr.courseID = rd.courseID";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns a students ongoing ungraded courses
     * @param studentID
     * @return
     * @throws SQLException 
     */
    public ResultSet getStudentsOngoingUngradedCourses(int studentID) throws SQLException {
        String query = "SELECT tb1.courseID, tb1.name, tb1.points FROM (SELECT cr.courseID CourseID, cr.name Name, cr.points Points FROM course cr INNER JOIN (SELECT courseID, studentID FROM reading WHERE studentID = " + studentID + ") AS rd ON cr.courseID = rd.courseID) AS tb1\n"
                + "LEFT OUTER JOIN (SELECT cr.courseID CourseID, cr.name Name, grade Grade FROM course cr INNER JOIN (SELECT courseID, grade FROM haveRead WHERE studentID = " + studentID + ") AS rd ON cr.courseID = rd.courseID) AS tb2\n"
                + "ON tb1.name = tb2.name\n"
                + "WHERE tb2.courseID IS null";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns the summed value of a students ongoing courses points
     * @param studentID
     * @param semester
     * @return
     * @throws SQLException 
     */
    public ResultSet getStudentsOngoingPoints(int studentID, String semester) throws SQLException {
        String query = "SELECT SUM(cr.points) Points FROM course cr INNER JOIN (SELECT courseID, studentID FROM reading WHERE studentID = '" + studentID + "') AS rd ON cr.courseID = rd.courseID WHERE cr.semester='" + semester + "'";
        ResultSet result = getQuery(query);
        return result;
    }

    /**
     * Returns a courses points
     * @param courseID
     * @return
     * @throws SQLException 
     */
    public ResultSet getCoursePoints(int courseID) throws SQLException {
        String query = "SELECT points FROM course where courseID=" + courseID;
        ResultSet result = getQuery(query);
        return result;
    }

}
