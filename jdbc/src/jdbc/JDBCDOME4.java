package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDOME4 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///htt", "root", "root");
            statement = connection.createStatement();
            String sql="delete from a where id=3";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            if (i>0){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                connection.close();
                System.out.println(true);
            }else{
                System.out.println(false);
            }
            if(statement!=null){
                statement.close();
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }

    }
}
