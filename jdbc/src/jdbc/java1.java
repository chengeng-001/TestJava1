package jdbc;

import jdbc.zibao.java2;
import org.omg.CORBA.StringHolder;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class java1 {
    private static String url;
    private  static  String user;
    private static String password;
    private static String driver;
    //注意使用此方法必须要求拥有工具类 工具类名称必须与命名的私有类相同
    static {
        try {//加载文件
            Properties properties = new Properties();
//            ClassLoader classLoader = java1.class.getClassLoader();
//            URL resource = classLoader.getResource("gojulei.properties");//定位路径
//            String path=null;
//            path = resource.getPath();
//            System.out.println(path);
//            properties.load(new FileReader(path));
            properties.load(java1.class.getClassLoader().getResourceAsStream("gojulei.properties"));
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取链接
    public static Connection a() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void  close(Statement satr,Connection conn)  {
        if(satr!=null){
            try {
                satr.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void  close(ResultSet rul,Statement satr, Connection conn)  {
        if(rul!=null){
            try {
                rul.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(satr!=null){
            try {
                satr.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        List<java2> finall = new JDBC4().finall();
        a();
        System.out.println(finall);
        //System.out.println(finall.size());
    }

    public List<java2> finall() throws SQLException {
        Statement statement =null;
        Connection connection =null;
        ResultSet resultSet =null;
        List<java2> list=null;
        try {
            connection=java1.a();//使用工具类  详细到java1查看  可以省略接入数据库的操作
            String sql="select * from dept ";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            java2 java2=null;
            list=new ArrayList<>();
            while(resultSet.next()){
                //此处应该跟数据库的类名一样
                int age = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double gozi = resultSet.getDouble("gozi");
                Date ruziriqi = resultSet.getDate("ruziriqi");
                int dept = resultSet.getInt("dept");
                java2 = new java2();
                //创建对象并赋值
                java2.setId(age);
                java2.setName(name);
                java2.setGozi(gozi);
                java2.setRuziriqi(ruziriqi);
                java2.setDept(dept);
                list.add(java2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
//            if(connection!=null){
//                connection.close();
//            }else{
//                System.out.println(false);
//            }
//            if(statement!=null){
//                statement.close();
//            }else{
//                System.out.println(false);
//            }
//            if(resultSet!=null){
//                resultSet.close();
//            }else{
//                System.out.println(false);
//            }
            java1.close(resultSet, statement, connection);

        }
        return list;
    }
}
