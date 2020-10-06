package DBTest;

import java.sql.*;

public class JDBCUsers {
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;

    String DBDriver="com.mysql.jdbc.Driver";
    String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
    String usn="root";
    String psd="root";

    public void getDBDriver(){
        //运行时可以修改类变量DBDriver的值
    }


    //获取数据库连接
    public Connection getConn(){
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

    //通过调用普通方法，向里边传参，来向数据库添加用户
    public int addParam(String name,String password,String age){
        int res=0;
        conn=this.getConn();
        try {
            stmt=conn.createStatement();
            String sql="insert into users(name,password,age) " +
                    "values('"+name+"','"+password+"','"+age+"')";
            res=stmt.executeUpdate(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        if(res!=0){
            System.out.println("添加用户成功");
        }else{
            System.out.println("添加用户失败");
        }
        return res;

    }


    //使用 面向对象思想，向数据库添加用户
    public int addUsers(Users user){
        int res=0;
        conn=this.getConn();
        try {
            String sql="insert into users(name,password,age) " +
                    "values(?,?,?) ";
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getAge());

            res=pstmt.executeUpdate();

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

    //使用面向对象思想，向里边删除一些用户
    public int delUsers(int id){
        int res=0;
        conn=this.getConn();
        try {
            stmt=conn.createStatement();
            String sql="delete  from users where id="+id;

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

    //使用面向对象的思想，改 数据库中的 表中的数据
    public int modifyUsers(Users user  ){
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

    //查找数据库中某一个用户 通过表中的任意一个字段（一般为主码）
    public int selectUsers(int id){
        int res=0;
        conn=this.getConn();
        Users user=new Users();
        try {
            /*String sql="select * from users where id="+id;
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);*/

            String sql="select * from users where id="+id;
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setAge(rs.getString(4));

            }
            System.out.print("用户ID："+user.getId()+"   用户名："+user.getName()+"   用户密码："+user.getPassword()+"   用户年龄："+user.getAge());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return res;

    }



    //获取数据库有多少个用户
    public int getCount(){
        int res=0;
        conn=this.getConn();
        try {
            stmt=conn.createStatement();
            String sql="select Count(*) from users";
            rs=stmt.executeQuery(sql);

            if(rs.next()){
                res=rs.getInt(1);
            }

            if(res!=0){
                System.out.println("查询用户成功");
            }else{
                System.out.println("查询用户失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        System.out.println("users表中总共有"+res+"个用户");
        return res;
    }


    private void close() {
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


    public static void main(String[] args) {
        JDBCUsers j1=new JDBCUsers();
        Users user=new Users();



        //使用普通方法传参 向数据库中添加数据 （用户）
        /*int res=j1.addParam("刘备","kjkjkj","22");
        if(res!=0){
            System.out.println("添加用户成功");
        }else{
            System.out.println("添加用户失败");
        }*/


        //使用面向对象思想 利用user对象向数据库中添加数据
        /*
        user.setName("张飞");
        user.setPassword("33333");
        user.setAge("25");
        int res2=j1.addUsers(user);*/

        /*user.setName("刘婵");
        user.setPassword("asdqwaaae123123213");
        user.setAge("21");
        j1.addUsers(user);*/

        //使用传参数的方法 删除id=11 的用户
        //j1.delUsers(14);
        j1.delUsers(36);

        //使用 面向对象的思想 调用修改方法 传入对象，修改对象相关数据
        /*user.setName("张飞");
        user.setPassword("123123213");
        user.setAge("22");
        user.setId(10);
        j1.modifyUsers(user);*/

        //查找users 表中总共有多少个用户
        j1.getCount();

        //通过调用selectUsers方法 传参id=7 来查询id=7 用户的所有信息
        j1.selectUsers(7);

    }
}
