
package com.JDBCTest1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test1 {
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;

    String DBDriver="com.mysql.jdbc.Driver";
    String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
    String usn="root";
    String psd="root";

    /*
     * jdbc 是基于sql 语句的访问技术，和dbms需要三个阶段的互动
     * 1 获取链接
     * 2 发送sql 语句
     * 3 获取返回的结果
     * 因此需要三个对象
     * */

    public void getDBDriver() {

    }

    public Connection getConn() {
        try {
            Class.forName(DBDriver);
            conn= DriverManager.getConnection(dburl,usn,psd);
            if(conn!=null) {
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }/*finally {
            this.close();
        }
        千万不能有这段代码，这段代码提前关闭了connection对象
        会报错 No operations allowed after connection closed。

        在对数据库操作结束后关闭连接是正确的做法，没什么大问题。
        至于出现：No operations allowed after connection closed。
        这样的问题原因只有一个，你这里和数据库的连接Connection是一个Static的，
        程序共享这一个Connection。
        所以第一次对数据库操作没问题，当把Connection关闭后，
        第二次还想操作数据库时Connection肯定不存在了。
        */
        return conn;
    }

    public int addParam(String name,String password,String age) {
        int res=0;
        conn=this.getConn();
        try {
            stmt=conn.createStatement();
            String sql="insert into users(name,password,age) " +
                    "values('"+name+"','"+password+"','"+age+"')";
            res=stmt.executeUpdate(sql);

            if(res!=0) {
                System.out.println("添加用户成功");
            }else {
                System.out.println("添加用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }

    public int addUsers(UsersTest2 user) {
        int res=0;
        conn=this.getConn();
        String sql="insert into users(name,password,age)"
                +"values(?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAge());

            res=pstmt.executeUpdate();

            if(res!=0) {
                System.out.println("添加用户法添加用户成功");
            }else {
                System.out.println("添加用户添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }

    public int delUser(int id ) {
        int res=0;
        conn=this.getConn();
        String sql="delete from users where id="+id;

        try {
            stmt=conn.createStatement();
            res=stmt.executeUpdate(sql);
            if(res!=0) {
                System.out.println("删除用户成功");
            }else {
                System.out.println("删除用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }

        return res;
    }

    public int modifyUser(UsersTest2 user) {
        int res=0;
        conn=this.getConn();
        String sql="update users set name=?,password=?,age=? where id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAge());

            res=pstmt.executeUpdate();

            if(res!=0) {
                System.out.println("修改用户成功");
            }else {
                System.out.println("修改用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;

    }

    public int getCount() {
        int res=0;
        try {
            stmt=conn.createStatement();
            String sql="select count(*) from users";
            rs=stmt.executeQuery(sql);

            while(rs.next()) {
                res=rs.getInt(1);
            }

            System.out.println("users表中共有："+res+"个用户");

            if(res!=0) {
                System.out.println("查询总数成功");
            }else {
                System.out.println("查询总数失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }

    public int selectUser(int id) {
        int res=0;
        conn=this.getConn();
        UsersTest2 user=new UsersTest2();
        try {
            stmt=conn.createStatement();
            String sql="select *from users where id="+id;

            rs=stmt.executeQuery(sql);
            while (rs.next()){
                user.setName(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setAge(rs.getString(3));

            }
            System.out.println("用户ID："+user.getId()+"用户名："+user.getName()+
                    "用户密码："+user.getPassword()+"用户年龄："+user.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }

    public List selectAll() {
        List li=new ArrayList();
        conn=this.getConn();
        try {
            stmt=conn.createStatement();
            String sql="select * from users";
            rs=stmt.executeQuery(sql);

            while(rs.next()) {
                UsersTest2 user=new UsersTest2();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAge(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }


        return li;
    }








    private void close() {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(pstmt!=null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[]  args) {
        test1 t1=new test1();
        UsersTest2 user=new UsersTest2();

        t1.getConn();
        t1.getCount();

    }


}



