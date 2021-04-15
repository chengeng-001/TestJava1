package jdbc;

import java.sql.*;

public class JDBCDOME5 {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;

        Statement statement = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection
                    ("jdbc:mysql:///htt", "root", "root");

            statement = connection.createStatement();
            String sql = "select * from a";
            ResultSet resultSet = statement.executeQuery(sql);
//            if (resultSet.next())//判断数据是否存在
//            {
//                int anInt = resultSet.getInt(1);//索引 坐标点
//                String name = resultSet.getString("name");//字符串名称
//                double aDouble = resultSet.getDouble(3);
//                System.out.println(anInt+" "+name+" "+aDouble);
//            }


            while (resultSet.next()) { //循环数据查找数据是否存在直到结束
                int anInt = resultSet.getInt(1);//索引 坐标点
                String name = resultSet.getString("name");//字符串名称
                double aDouble = resultSet.getDouble(3);
                System.out.println(anInt + " " + name + " " + aDouble);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
                System.out.println(true);
            } else {
                System.out.println(false);
            }
            if (statement != null) {
                statement.close();
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
}
