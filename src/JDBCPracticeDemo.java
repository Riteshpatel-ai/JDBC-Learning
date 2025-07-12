import java.sql.*;

public class JDBCPracticeDemo {
    public static void main(String[] args) {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testStudent", "root", "Ritesh9878");

            // Prepare SQL query
            String query = "INSERT INTO Student (id, sName, Age) VALUES (?, ?, ?)";
            PreparedStatement pr = con.prepareStatement(query);

            // Set values
            pr.setInt(1, 5);
            pr.setString(2, "Sivansh");
            pr.setInt(3, 10);

            // ✅ Execute the insert
            int rowsInserted = pr.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            // Close resources
            pr.close();
            con.close();

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("MySQL JDBC Driver not found.", ex);
        } catch (SQLException ex) {
            throw new RuntimeException("Database error.", ex);
        }
    }
}
