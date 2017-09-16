package com.zcy.db.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0DBUtil {
    //创建数据源，自动加载存在的配置文件
    public static ComboPooledDataSource ds=new ComboPooledDataSource();

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
