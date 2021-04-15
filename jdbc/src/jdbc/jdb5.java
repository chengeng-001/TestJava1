package jdbc;

import java.sql.*;
import java.util.Scanner;

public class jdb5 {

    //使用时数据库 必须存在一个user的表 而且内容必须存在
    public boolean a(String name,String password) {
        if(name==null&&password==null){
            return false;
        }
        Connection a =null;
        //Statement statement =null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        try {
            a = java1.a();
            //定义sql
            String sql="select * from a where name =? and password=?";
            //select * from a where name =? and password=?select * from a where name ='"+name+"' and password='"+password+"'
            //statement = a.createStatement();
            //后期会使用preparedStatement进行增删改查的操作
            //可以防止mysql注入
            //效率更高
            preparedStatement = a.prepareStatement(sql);//执行sql对象
            preparedStatement.setString(1,name);//切记要给问号赋值
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();//执行了查询不需要传递sql
           return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            java1.close(resultSet,preparedStatement, a);
        }
        return false;
    }
   //不成熟的数据登录可以使用此密码登录  也就是mysql注入a' or 'a' = 'a
    //在拼接sql时，有一些sql的特殊的关键字参与字符串的连接 会造成安全性问题
    public static void main(String[] args) {
        Scanner a=new Scanner(System.in);
        String s = a.nextLine();
        String s1 = a.nextLine();
        boolean a1 = new jdb5().a(s, s1);
        if (a1){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
