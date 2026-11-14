import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class PostgreSQLJDBCConnection {
    public static void main(String[] args) {
// JDBC & Database credentials
        String url = "jdbc:postgresql://localhost:5432/3005A3";
        String user = "postgres";
        String password = "postgres";
        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
// Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to PostgreSQL successfully!");

                // Function calls
                System.out.println("Calling getAllStudents: \n");
                QueryHelpers.getAllStudents(conn);
                System.out.println("\nCalling addStudent: ");
                QueryHelpers.addStudent(conn, "Jenn", "McAllister",
                        "jennmcallister@example.com", LocalDate.of(2025, 9, 11));


            } else {
                System.out.println("Failed to establish connection.");
            } // Close the connection (in a real scenario, do this in a finally)
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}