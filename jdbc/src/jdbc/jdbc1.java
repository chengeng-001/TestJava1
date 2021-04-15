package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc1 {
    //导入驱动jar包
    public static void main(String[] args) throws Exception {
       // Class.forName("com.mysql.jdbc.Driver");//加载项目
        //连接数据库
        //包名 用户主机名 端口号  连接的库名称  用户名  密码
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/htt", "root", "root");
        //定义sql语句
        //String sql="update a set balacn = balacn +1000 where id=1";
        String sql="insert into a values (null ,'王五',2000)";


        //获取mysql对象
        Statement statement = connection.createStatement();

        //执行
        int i = statement.executeUpdate(sql);
        //处理
        System.out.println(i);
        //释放资源
        statement.close();
        connection.close();
    }
}
