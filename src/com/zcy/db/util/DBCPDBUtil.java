package com.zcy.db.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPDBUtil {
    /*数据源*/
    private static DataSource DS;

    private static final String configFile="/dbcp.properties";

    public DBCPDBUtil(){
        initDbcp();
    }

    public  Connection getConnection(){
        Connection con=null;
        if (DS!=null){
            try {
                con=DS.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                con.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        }
        return con;

    }

    private static void initDbcp(){
        Properties pops=new Properties();
        try {
            pops.load(Object.class.getResourceAsStream(configFile));
            DS= BasicDataSourceFactory.createDataSource(pops);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造函数，初始化 DS，指定数据库
     */
//    public DBCPDBUtil(String connectURI){
//        initDS(connectURI);
//    }
//
//    private void initDS(String connectURI) {
//    }

    /**构造函数，初始化DS，指定所有参数*/
   public DBCPDBUtil(String connectURI,String username,String pswd,String driverClass,int initialSize,int maxActive,
                     int maxtotal,int maxIdle,int maxWait,int minIdle){
        initDS(connectURI,username,pswd,driverClass,initialSize,maxActive,maxtotal,maxIdle,maxWait,minIdle);
   }

   //创建数据源，除了数据库外，都使用硬编码默认参数
    private void initDS(String connectURI, String username, String pswd, String driverClass, int initialSize, int maxActive,int maxtotal ,int maxIdle, int maxWait, int minIdle) {
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUsername(username);
        ds.setPassword(pswd);
        ds.setUrl(connectURI);
        ds.setInitialSize(initialSize);//初始连接数
        ds.setMaxTotal(maxtotal);
        ds.setMaxWaitMillis(maxWait);
        ds.setMinIdle(minIdle);
        DS=ds;
    }


}
