package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDOME3 {
    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql:///htt", "root", "root");
            String sql = "update a set balacn = balacn -500 where id=3";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);//上传
            System.out.println(i);
            if (i > 0) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                System.out.println(1);
                statement.close();
            } else {
                System.out.println(2);
            }
            if (connection != null) {
                System.out.println(1);
                connection.close();
            } else {
                System.out.println(2);
            }
        }

    }
}
