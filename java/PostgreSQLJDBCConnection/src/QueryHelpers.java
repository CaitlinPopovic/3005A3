import java.sql.*;
import java.time.LocalDate;


public class QueryHelpers { // helper class solely containing functions that interact with the database

    private QueryHelpers(){}

    public static void getAllStudents(Connection c) throws SQLException { // lists all of the students and their ->
        // data in the database

        Statement stmt = c.createStatement();
        String SQL = "SELECT * FROM Students"; // SQL query
        ResultSet rs = stmt.executeQuery(SQL); // storing the ResultSet so we can extract the data
        while (rs.next()) {
            // storing the data in variables so we can print them out
            int student_id = rs.getInt("student_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");
            LocalDate enrollment_date = rs.getObject("enrollment_date", LocalDate.class);

            System.out.println("Student ID: " + student_id + ", Name: " + first_name + " " +
                    last_name + ", Email: " + email + ", Enrollment Date: " + enrollment_date);
        }

        rs.close();
        stmt.close();

    }

    public static void addStudent(Connection c, String  first_name, String last_name,
                                  String email, LocalDate enrollment_date) throws SQLException {; // inserts ->
        // a new student into the Students table

        String insertSQL = "INSERT INTO students (first_name, " +
                "last_name, email, enrollment_date) VALUES (?, ?, ?, ?)"; // SQL query

        try (PreparedStatement pstmt = c.prepareStatement(insertSQL)) { // precompiled SQL statement
            // filling in each value for our INSERT:
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setObject(4, enrollment_date);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!\n");
        }

    }

    public static void updateStudentEmail(Connection c, int student_id, String new_email) throws SQLException {
    // ^ this function updates a student's email address using their student ID

        String updateSQL = "UPDATE Students SET email = ? WHERE student_id = ?"; // SQL query

        try (PreparedStatement pstmt = c.prepareStatement(updateSQL)) {  // precompiled SQL statement
            // filling in each value for our SET operation:
            pstmt.setString(1, new_email); // setting the new email
            pstmt.setInt(2, student_id); // condition
            pstmt.executeUpdate();
            System.out.println("Student's email was successfully updated to " + new_email + ". \n");
        }
    }

    public static void deleteStudent(Connection c, int student_id) throws SQLException { // deletes ->
        // a student record from the Students table based on the given ID

        String deleteSQL = "DELETE FROM Students WHERE student_id = ?"; // SQL query
        try (PreparedStatement pstmt = c.prepareStatement(deleteSQL)) { // precompiled SQL statement
            // filling in the condition for the DELETE query:
            pstmt.setInt(1, student_id); // condition
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully!\n");
        }

    }



}
