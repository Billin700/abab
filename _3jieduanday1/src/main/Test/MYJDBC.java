import org.junit.Test;

import java.sql.*;

public class MYJDBC {
 @Test
    public void test() throws ClassNotFoundException, SQLException {
     //加载驱动
     Class.forName("com.mysql.jdbc.Driver");
     //创建连接对象
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
             "root",
             "root");
     //创建sql语句
     String sql = "INSERT INTO aaaa VALUES(?,?,?,?) ";
     //创建预编译对象
     PreparedStatement preparedStatement = conn.prepareStatement(sql);
     preparedStatement.setInt(1,11);
     preparedStatement.setObject(2,"6");
     preparedStatement.setObject(3,"6");
     preparedStatement.setInt(4,6);
     //执行sql语句
     boolean execute = preparedStatement.execute();
     System.out.println(execute+"000000");
     if (execute){
         System.out.println("成功");
     }else{
         System.out.println("失败");
     }
     preparedStatement.close();
     conn.close();

 }
 @Test
    public void test1() throws ClassNotFoundException, SQLException {
     //加载驱动
     Class.forName("com.mysql.jdbc.Driver");
     //创建连接对象
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
             "root",
             "root");
     //准备sql语句
     String sql = "update aaaa set state = 0 where id = ?" ;
     //创建预编译对象
     PreparedStatement preparedStatement = conn.prepareStatement(sql);
     preparedStatement.setInt(1,4);
     //执行sql语句
     int i = preparedStatement.executeUpdate();
     if (i>0){
         System.out.println("成功");
     }else {
         System.out.println("失败");
     }
     preparedStatement.close();
     conn.close();
 }
}
