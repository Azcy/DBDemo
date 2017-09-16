package com.zcy.db.demo;

import com.zcy.db.util.DBUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbDemo {
    public static void main(String[] args) {

        Connection conn= DBUtil.getConnection();
        try {
            //调用存储过程 call+存储过程的名称
            CallableStatement c=conn.prepareCall("call sp_select_nofiter()");
            c.execute();
            ResultSet rs=c.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
