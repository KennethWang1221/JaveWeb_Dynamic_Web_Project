package cn.itcast.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.List;

public class JDBCTempateDemo2 {
    //查询 让其返回某一个值


    //查询表中有多少条记录
    @Test
    public void testCount() {
        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hibernate_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //创建 jdbcTemplate 对象 ，设置数据源
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        //调用 方法得到记录数
        String sql="select count(*) from user";
        //调用 jdbcTemplate 的方法
        int count=jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);

    }


    //查询返回对象
    @Test
    public void testObject() {
        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hibernate_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //创建 jdbcTemplate 对象 ，设置数据源
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        //写 sql语句 ，根据 username 查询
        String sql="select * from user where username=?";
        //调用 jdbcTemplate 的方法

        /*
        * 第一个参数是sql语句
          第二个参数是 RowMapper，是一个接口 RowMapper 需要自己写类实现接口，自己做数据封装 ,类似于dbutils里面接口
          第三个参数是 可变参数
        *
        * */

        User user=jdbcTemplate.queryForObject(sql,new MyRowMapper(),"lucy");
        System.out.println(user);


    }



    //查询返回 list集合
    @Test
    public void testList() {

        /*ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///spring_day03");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        利用代码设置 c3p0 连接池 的信息 现在用spring 中的文件配置实现
        */




        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hibernate_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //创建 jdbcTemplate 对象 ，设置数据源
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        //写 sql语句 ，根据 username 查询
        String sql="select * from user ";
        //调用 jdbcTemplate 的方法

        /*
        * 第一个参数是sql语句
          第二个参数是 RowMapper，是一个接口 RowMapper 需要自己写类实现接口，自己做数据封装 ,类似于dbutils里面接口
          第三个参数是 可变参数
        *
        * */

        List<User> list=jdbcTemplate.query(sql,new MyRowMapper());
        System.out.println(list);


    }


    // 2 jdbc 最原始实现查询代码
    @Test
    public void testJdbcSelect() {
        Connection conn=null;
        Statement stmt=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String DBDriver="com.mysql.jdbc.Driver";
        String dburl="jdbc:mysql://127.0.0.1:3306/hibernate_day03";
        String usn="root";
        String psd="root";
        /*
         * jdbc 是基于sql 语句的访问技术，和dbms需要三个阶段的互动
         * 1 获取链接
         * 2 发送sql 语句
         * 3 获取返回的结果
         * 因此需要三个对象
         * */
        try {
            Class.forName(DBDriver);

            //创建连接
            conn=DriverManager.getConnection(dburl,usn,psd);
            int res=0;

            //编写sql语句
            String sql="select * from user where username=?";

            //预编译sql
            pstmt=conn.prepareStatement(sql);

            //设置参数值
            pstmt.setString(1,"lucy");

            //执行 sql
            rs=pstmt.executeQuery();

            //遍历 结果集
            while (rs.next()) {
                //得到 结果值
                User user=new User();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));

                System.out.println("用户名："+user.getUsername()+
                        "用户密码："+user.getPassword());

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

//RowMapper<User>,泛型 这里表示，要把数据封装到哪个对象中去，写的就是 这个对象所在的类的名字
class MyRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int num) throws SQLException {
        // 1 从结果集里面把数据得到
        User user=new User();
        user.setUsername(rs.getString(1));
        user.setPassword(rs.getString(2));
        // 2 把得到数据封装到对象里边
        return user;

    }
}

