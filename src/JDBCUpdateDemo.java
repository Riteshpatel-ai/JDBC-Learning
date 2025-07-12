import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

class JDBCUpdateDemo{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testStudent","root","Ritesh9878");
            Statement stmt=cn.createStatement();
            String query="Update Student set age=14 where id=105";
            int update=stmt.executeUpdate(query);
            System.out.println("Update"+update+" rows");

        }
            catch(Exception e){
                System.out.println(e);
            }

    }
}

