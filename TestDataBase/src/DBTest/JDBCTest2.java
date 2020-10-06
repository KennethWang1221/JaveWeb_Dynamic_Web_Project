package DBTest;

import java.sql.*;
import java.util.*;


public class JDBCTest2{
    Connection conn =null;
    Statement stmt=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;

    String DBDriver="com.mysql.jdbc.Driver";
    String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
    String usn="root";
    String psd="root";

    public void getDBDriver(){

    }

    public Connection getConn(){
        try {
            Class.forName(DBDriver);
            conn= DriverManager.getConnection(dburl,usn,psd);
            if(conn!=null){
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public int addParam(String name,String password,String age){
        int res=0;
        conn=this.getConn();
        try {
            stmt=conn.createStatement();
            String sql="insert into users(name,password,age) " +
                    "values('"+name+"','"+password+"','"+age+"')";


            res=stmt.executeUpdate(sql);
            if(res!=0){
                System.out.println("添加用户成功");
            }else{
                System.out.println("添加用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }


        return res;
    }

    public int addUsers(UsersTest2 user){
        int res=0;
        conn=this.getConn();
        String sql="insert into users(name,password,age) " +
                "VALUES (?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAge());

            res=pstmt.executeUpdate();

            if(res!=0){
                System.out.println("添加用户法添加用户成功");
            }else{
                System.out.println("添加用户添加用户失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }


    public int delUser(int id ){
        int res=0;
        conn=this.getConn();
        String sql="delete from users where id="+id;
        try {
            stmt=conn.createStatement();
            res=stmt.executeUpdate(sql);

            if(res!=0){
                System.out.println("删除用户成功");
            }else{
                System.out.println("删除用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }

    public int modifyUSer(UsersTest2 user){
        int res=0;
        conn=this.getConn();
        String sql="update users set name=?,password=?,age=? where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAge());
            pstmt.setInt(4,user.getId());
            res=pstmt.executeUpdate();
            if(res!=0){
                System.out.println("修改用户成功");
            }else{
                System.out.println("修改用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }


    public int getCount(){
        int res=0;
        conn=this.getConn();
        try {
            stmt=conn.createStatement();
            String sql="select count(*) from users";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                res=rs.getInt(1);
            }

            System.out.println("users表中共有："+res+"个用户");
            if(res!=0){
                System.out.println("查询总数成功");
            }else{
                System.out.println("查询总数失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            this.close();
        }



        return res;
    }

    public int selectUser(int id){
        int res=0;
        conn=this.getConn();
        UsersTest2 user=new UsersTest2();
        try {
            stmt=conn.createStatement();
            String sql="select * from users where id="+id;
            rs=stmt.executeQuery(sql);

            while(rs.next()){
                user.setName(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setAge(rs.getString(3));
                user.setId(rs.getInt(4));
            }
            System.out.println("用户ID："+user.getId()+"   用户名："+user.getName()+"   用户密码："+user.getPassword()+"   用户年龄："+user.getAge());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;
    }

    public List selectAll(){
        List li=new ArrayList();
        conn=this.getConn();
        try{
            stmt=conn.createStatement();
            String sql="select * from users";
            rs=stmt.executeQuery(sql);

            while(rs.next()){
                UsersTest2 user=new UsersTest2();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAge(rs.getString(4));
                li.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            this.close();
        }
        return li;
    }

    private void close() {
        if(rs!=null){
            try {
                rs.close();
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

        if(pstmt!=null){
            try {
                pstmt.close();
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


    public static void main(String[] args) {
            JDBCTest2 j2=new JDBCTest2();
            UsersTest2 user=new UsersTest2();

            /*user.setName("许褚");
            user.setPassword("xxxx");
            user.setAge("23");
            j2.addUsers(user);*/

            //j2.addParam("周瑜","pppaaa","22");

            /*user.setName("许褚");
            user.setPassword("qqq");
            user.setAge("24");
            user.setId(23);
            j2.modifyUSer(user);*/

            //j2.delUser(25);
            j2.selectAll();
            List<UsersTest2> list=new ArrayList<UsersTest2>();
            list=j2.selectAll();
            for(int i=0;i<list.size();i++){
                System.out.println("第"+(i+1)+"条用户的ID为:"+list.get(i).getId());
                System.out.println("第"+(i+1)+"条用户的username值为:"+list.get(i).getName());
                System.out.println("第"+(i+1)+"条用户的password为:"+list.get(i).getPassword());
                System.out.println("第"+(i+1)+"条用户的age为:"+list.get(i).getAge());

            }



            //j2.getCount();
            //j2.selectUser(8);
    }
}