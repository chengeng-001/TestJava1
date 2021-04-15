package jdbc;

import jdbc.zibao.java2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC3 {
    public static void main(String[] args) throws SQLException {
        List<java2> finall = new JDBC3().finall();
        System.out.println(finall);
    }

    public List<java2> finall() throws SQLException {
        Statement statement =null;
        Connection connection =null;
        ResultSet resultSet =null;
        List<jdbc.zibao.java2> list=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
             connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
            //定义sql语句
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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(connection!=null){
                connection.close();
            }else{
                System.out.println(false);
            }
            if(statement!=null){
                statement.close();
            }else{
                System.out.println(false);
            }
            if(resultSet!=null){
                resultSet.close();
            }else{
                System.out.println(false);
            }

        }
        return list;
    }
}
