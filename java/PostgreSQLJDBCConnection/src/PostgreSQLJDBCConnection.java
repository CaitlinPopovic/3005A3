import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//private void getAllStudents() {
//    // Create statement
//    Statement stmt = conn.createStatement();
//}



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