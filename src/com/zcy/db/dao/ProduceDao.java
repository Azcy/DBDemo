package com.zcy.db.dao;

import com.sun.deploy.security.ValidationState;
import com.zcy.db.bean.Goddess;
import com.zcy.db.util.C3P0DBUtil;
import com.zcy.db.util.DBCPDBUtil;
import com.zcy.db.util.DBUtil;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduceDao  {

    /**
     * 查找所有信息
     * @return
     * @throws SQLException
     */
    public static List<Goddess> select_nofilter() throws SQLException {
        /*
        sql:不带参数
          Create procedure v3()
          BEGIN
          SELECT * FROM imooc_goddess;
          END
         */
        List<Goddess> list=new ArrayList<Goddess>();
        //1,获得链接
        Connection conn=DBUtil.getConnection();

        //2,获得callablestatement
        CallableStatement c = conn.prepareCall("call v3()");

        //3,执行存储过程
        c.execute();

        //4,处理返回的结果：结果集
        ResultSet rs=c.getResultSet();

        while (rs.next()){
            Goddess goddess=new Goddess();
            goddess.setAge(rs.getInt("age"));
            goddess.setBirthday(rs.getDate("birthday"));
            goddess.setCreate_date(rs.getString("create_date"));
            goddess.setId(rs.getInt("id"));
            goddess.setEmail(rs.getString("email"));
            goddess.setIsdel(rs.getInt("isdel"));
            goddess.setMobile(rs.getString("mobile"));
            goddess.setSex(rs.getInt("sex"));
            goddess.setUser_name(rs.getString("user_name"));
            goddess.setUpdate_date(rs.getString("update_date"));
            //System.out.println(goddess);
            list.add(goddess);

            //System.out.println(rs.getString("user_name"));
        }
        conn.close();
        return list;
    }


    /**
     *  带参数的存储过程
     * @param name 姓名
     * @return
     * @throws SQLException
     */
    public static Goddess seletByname(String name) throws SQLException {

        /*
        sql:带参数的存储过程
        CREATE PROCEDURE k(IN name VARCHAR)
        BEGIN
        SELECT * FROM imooc_goddess WHERE user_name=name;
        END
         */
        //1,获得链接
        Connection conn=DBUtil.getConnection();
        //2，创建存储过程
        CallableStatement c =conn.prepareCall("call k(?)");
        //3,插入参数
        c.setString(1,name);
        //4.执行存储过程
        c.execute();
        //5,返回集合
        ResultSet rs=c.getResultSet();
        //6,将集合遍历存储到对象中
          Goddess goddess=new Goddess();
        while (rs.next()){

            goddess.setAge(rs.getInt("age"));
            goddess.setBirthday(rs.getDate("birthday"));
            goddess.setCreate_date(rs.getString("create_date"));
            goddess.setId(rs.getInt("id"));
            goddess.setEmail(rs.getString("email"));
            goddess.setIsdel(rs.getInt("isdel"));
            goddess.setMobile(rs.getString("mobile"));
            goddess.setSex(rs.getInt("sex"));
            goddess.setUser_name(rs.getString("user_name"));
            goddess.setUpdate_date(rs.getString("update_date"));
        }
        //System.out.println(goddess);
        //7，关闭链接
        conn.close();
        return goddess;
    }

    /**
     * 查找数量
     * @return 返回表中数据的条数
     * @throws SQLException
     */
    public static int selectCount() throws SQLException {
        /*
        sql:带输出的存储过程
        CREATE PROCEDURE k1(OUT count INT(10))
        BEGIN
        SELECT COUNT(*) INTO count FROM imooc_goddess;
        END

        cmd：
        call k1(@k);
        select @k;
         */
        Integer count=0;
        //1,获得链接
        DBCPDBUtil dbcpdbUtil=new DBCPDBUtil();
        //Connection conn= C3P0DBUtil.getConnection();
        Connection conn=dbcpdbUtil.getConnection();

        //2，创建存储过程
        CallableStatement c =conn.prepareCall("call k1(?)");
        c.registerOutParameter(1, Types.INTEGER);
        //3,执行存储过程
        c.execute();

        //4.获取结果集，并处理问题
        count=c.getInt(1);

        return count;
    }

    public static void main(String[] args) throws SQLException {
      /* List<Goddess> list=select_nofilter();
       for (Goddess goddess:list){
           System.out.println(goddess);
       }*/

//      Goddess goddess=new Goddess();
//      goddess=seletByname("平");
        System.out.println(selectCount());
        //DBUtil.getuser();
    }




}
