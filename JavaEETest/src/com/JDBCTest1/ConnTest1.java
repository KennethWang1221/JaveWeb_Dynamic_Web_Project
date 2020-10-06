package com.JDBCTest1;

import java.sql.*;

public class ConnTest1 {
    /*
    * jdbc 访问数据库分为三个阶段
    * 1 获取数据库的连接
    * 2 向数据库dbms发送sql语句
    * 3 返回dbms执行sql语句的结果
    * */

    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;

    public void getConn() {
        /*
        * 连接 mysql 数据库，获取连接对象
        * */

        //实例化一个具体数据库的驱动对象
        //Java中带包名的类，称作"完全限定名"，简称全名
        try {
            new com.mysql.jdbc.Driver();
            //如果上面的语句实例化成功，则在内存中会产生一个mysql数据库数据库驱动对象
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logintest","root","root");
            //如果conn 实例化成功，则表示连接数据库成功
            if(conn != null) {
                System.out.println("数据库连接成功");
            }
            else {
                System.out.println("数据库连接失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    //使用conn对象，创建语句对象
    public void getStmt() {
        if(conn!=null) {
            try {
                stmt=conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    //获取某个数据表的记录数
    public void getCount() {
        if(stmt!=null) {
            int res=0;
            String sql="select count(*) from users";
            try {
                rs=stmt.executeQuery(sql);

                if(rs.next()) {
                    res=rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println(res);
        }
    }



    public static void main(String[] args) {
        ConnTest1 t1=new ConnTest1();
        t1.getConn();
        t1.getStmt();
        t1.getCount();
    }
}
