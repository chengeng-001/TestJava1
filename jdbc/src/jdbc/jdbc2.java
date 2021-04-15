package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2 {
    public static void main(String[] args) {
        Statement statement =null;
        Connection connection = null;
        //注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "insert into a values (null,'王五',1000)";
            //切记不要加空格
            connection= DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/htt","root","root");
            //获取执行对象
             statement=connection.createStatement();
            //执行对象
            int i=statement.executeUpdate(sql);
            if (i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           if(statement!=null){
               try {
                   statement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }else{
               System.out.println("没有申请资源");
           }
            if(connection!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("没有申请资源");
            }
        }


    }
}
