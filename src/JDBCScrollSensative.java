import java.sql.*;
public class JDBCScrollSensative {
        public static void main(String[] args) {
            try {
                // 1. Load JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // 2. Establish Connection
                Connection cn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/testStudent", "root", "Ritesh9878"
                );

                // 3. Create Statement with SENSITIVE ResultSet
                Statement stmt = cn.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );

                // 4. Execute Query
                ResultSet rs = stmt.executeQuery("SELECT * FROM student");

                // 5. First Time Reading
                System.out.println(" First Read:");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " +
                            rs.getString("sName") + " - " +
                            rs.getInt("age"));
                }

                // 6. Wait for you to update data in DB
                System.out.println("\nNow go update age of any student in DB (e.g., id=101)");
                System.out.println("Then press ENTER here to continue...");
                System.in.read(); // wait for Enter key

                // 7. Reset cursor to start
                Thread.sleep(1000);
                rs.beforeFirst();

                // 8. Read again (live data)
                System.out.println("\nSecond Read (Live Update):");

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " +
                            rs.getString("sName") + " - " +
                            rs.getInt("age"));
                }

                // 9. Close
                cn.close();

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
