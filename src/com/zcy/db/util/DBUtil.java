package com.zcy.db.util;

import java.sql.*;

public  class DBUtil {
    public static Connection getConnection()   {
        Connection conn=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/mybatis";
            conn= DriverManager.getConnection(url,"root","root");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void getuser() throws SQLException {
        Connection conn=getConnection();
        Statement cmd= conn.createStatement();
        ResultSet rs=cmd.executeQuery("SELECT * FROM tb_user ");
        while (rs.next()){
            System.out.println(rs.getString("loginname"));
        }
        conn.close();
    }
}
