package DBTest;

import java.sql.*;

public class JDBCTest1{
    /*
    * JDBC 是基于sql语句的访问技术，和dbms需要三个阶段的互动
    * 1 获取连接
    * 2 发送sql语句
    * 3 获取返回的结果
    * 因此需要三个对象
    * */
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    String DBDriver="com.mysql.jdbc.Driver";
    String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
    String usn="root";
    String psd="root";

    //定义一个方法，专门从某个文件中读取值
    public void getDBDriver(){
        //运行时可以修改变量DBriver 的值
    }

    //获取数据库连接
    public Connection getConn() {
        //尝试着修改conn变量的值
        try {
            Class.forName(DBDriver);
            conn= DriverManager.getConnection(dburl,usn,psd);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //向数据库添加记录的方法
    public int addUserParam(String username,String password,String address,String email,String sex,String bir){
        int res=0;
        conn=this.getConn();
        if(conn!=null){
            try {
                stmt=conn.createStatement();
                String sql="insert into userinfo(username,password,address,email,sex,birthday)" +
                        "values('"+username+"','"+password+"','"+address+"','"+email+"','"+sex+"','"+bir+"')";
                res=stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                this.close();
            }

        }
        return res;
    }

    //使用面向对象的思想，添加一个用户应该是添加一个用户对象
    public int addUser(UserVo user){
        int res=0;
        try {
            conn=this.getConn();
            String sql="insert into userinfo(username,password,address,email,sex,birthday) values(?,?,?,?,?,?)";
            //预处理语句对象，需要对sql语句进行预处理，所以先要定义sql语句的字符串

            pstmt=conn.prepareStatement(sql);
            //对预处理语句对象的sql占位符(?)进行赋值操作
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAddress());
            pstmt.setString(4,user.getEmail());
            pstmt.setString(5,user.getSex());
            pstmt.setDate(6,new java.sql.Date(user.getBirthday().getTime()));
            //向dbms发送
            res=pstmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.close();
        }
        return res;
    }

    public int modifyUser(UserVo user){
        int res=0;
        try {
            conn=this.getConn();
            String sql="update userinfo set username=?,password=?,address=?,email=?,sex=?,birthday=? where uid=?";
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAddress());
            pstmt.setString(4,user.getEmail());
            pstmt.setString(5,user.getSex());
            pstmt.setDate(6,new java.sql.Date(user.getBirthday().getTime()));
            pstmt.setInt(7,user.getUid());
            res=pstmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.close();
        }

        return res;
    }

    public void  getCount(){
        int res=0;
        try {
            //Class.forName(DBDriver);
            conn=this.getConn();
            stmt=conn.createStatement();
            String sql="select Count(*) from userinfo";
            rs=stmt.executeQuery(sql);

            if(rs.next()){
                res=rs.getInt(1);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            this.close();
        }
        System.out.println("userinfo表中含有"+res+"个用户");

        //return  res;
    }

    //根据uid 或者某个唯一的字段，进行删除记录
    public int deluserinfo(int uid){
        int res=0;
        try {
            conn=this.getConn();
            stmt=conn.createStatement();
            String sql="delete *  from userinfo where uid="+uid;
            res=stmt.executeUpdate(sql);
        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }


        return res;
    }

    //当一段代码段重复三次以上，应该将其抽取出来，封装成为一个单独的方法，方便调用

    public  void close() {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        }



    public static void main(String [] args){
        JDBCTest1 t1=new JDBCTest1();
        /*int res=t1.addUserParam("关羽","123qwe","山东","123@qq.com","男","1993-8-9");
        if(res>0){
            System.out.println("添加用户成功");
        }else{
            System.out.println("添加用户失败");
        }*/


       /* UserVo user=new UserVo();
        user.setUsername("刘备备");
        user.setPassword("456yui");
        user.setAddress("河南");
        user.setSex("男");
        user.setEmail("3434@163.com");
        user.setUid(3);
        java.util.Date md=new java.util.Date();
        md.setYear(1995);
        md.setMonth(6);
        md.setDate(6);
        user.setBirthday(md);
        user.setUid(3);        int res=t1.addUser(user);
        if(res>0){
            System.out.println("添加用户成功");
        }else{
            System.out.println("添加用户失败");
        }
*/
       /* int res=t1.addUserParam("小乔","567wwqwe","河北","123rrr@qq.com","女","1996-8-9");
        if(res>0){
            System.out.println("添加用户成功");
        }else{
            System.out.println("添加用户失败");
        }    */

       /*int res=t1.deluserinfo(6);
       if(res>0){
           System.out.println("删除用户成功");
       }else{
           System.out.println("删除用户失败");
       }*/

       t1.getCount();
       //System.out.println(t1.getCount());
    }

}