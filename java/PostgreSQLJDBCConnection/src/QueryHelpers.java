import java.sql.*;
import java.time.LocalDate;


public class QueryHelpers {

    private QueryHelpers(){}

    public static void getAllStudents(Connection c) throws SQLException {

        Statement stmt = c.createStatement();
        String SQL = "SELECT * FROM students";
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
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
                                  String email, LocalDate enrollment_date) throws SQLException {;

        String insertSQL = "INSERT INTO students (first_name, " +
                "last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = c.prepareStatement(insertSQL)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setObject(4, enrollment_date);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!\n");
        }

    }



}
