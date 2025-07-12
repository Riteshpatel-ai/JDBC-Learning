import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String []args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testStudent","root","Ritesh9878");
            Statement statement=cn.createStatement();
            String query="select * from student";
            ResultSet rs=statement.executeQuery(query);
            System.out.println("------Read the data------------");
            while(rs.next()){
                System.out.println(
                        rs.getInt("id")+" | "+
                                rs.getString("sname")+ " | "+
                        rs.getInt("age")+" |"
                );
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
