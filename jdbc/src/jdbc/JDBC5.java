package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC5 {
    public static void main(String[] args) {
        Connection a = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            //获取链接
            a = java1.a();
            a.getAutoCommit();//开启事务  如果出现异常返回到此处
            String sql = "update a set balacn = balacn +? where id=?";
            String sql1 = "update a set balacn = balacn -? where id=?";
            preparedStatement = a.prepareStatement(sql);
            preparedStatement1 = a.prepareStatement(sql1);
            preparedStatement.setDouble(1, 500);
            preparedStatement.setInt(2, 1);//移动位置

            preparedStatement1.setDouble(1, 500);
            preparedStatement1.setInt(2, 2);

            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();

            a.commit();

        } catch (SQLException e) {
            //在处理异常的程序中进行回滚也就是返回事务
            try {
                if (a != null) {
                    a.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            java1.close(preparedStatement, a);
            java1.close(preparedStatement1, null);
        }
    }
}
