import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCInsertDemo {
        public static void main(String []args){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/testStudent", "root", "Ritesh9878");
                Statement statement = cn.createStatement();
                String query = "Insert Into student (id,sName,age) values(4,'Sanjeep',30)";
                int querys = statement.executeUpdate(query);
                System.out.println("inserted "+querys+" Rows");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }


