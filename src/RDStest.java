

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RDStest {

    public static void main(String[] args) {

        Connection conn = null;
        String sql;
        String url = "jdbc:mysql://rm-wz9o3dj7rv8xeh154.mysql.rds.aliyuncs.com:3306?zeroDateTimeBehavior=convertToNull";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","Kowj728138");
            Statement stmt = conn.createStatement();
            String  sqlusedb="use myzcy";

            int result1 = stmt.executeUpdate(sqlusedb);

            sql = "create table teacher(NO char(20),name varchar(20),primary key(NO))";
            int result = stmt.executeUpdate(sql);
            if (result != -1) {

                sql = "insert into teacher(NO,name) values('2016001','wangsan')";
                result = stmt.executeUpdate(sql);
                sql = "insert into teacher(NO,name) values('2016002','zhaosi')";
                result = stmt.executeUpdate(sql);
                sql = "select * from teacher";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}