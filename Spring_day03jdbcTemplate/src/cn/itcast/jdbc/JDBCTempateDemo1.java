package cn.itcast.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class JDBCTempateDemo1 {
    // 1 添加操作
    @Test
    public void add() {
        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hibernate_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        // 创建jdbcTemplate 对象 ，设置数据源
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        // 调用jdbcTemplate 对象里面的方法实现操作
        //创建sql语句
        String sql="insert into user values(?,?)";

        //此update 方法 返回int 类型的值，表示 影响的行数
        int rows=jdbcTemplate.update(sql,"lucy","250");
        System.out.println(rows);
    }

    //修改操作
    @Test
    public void update() {
        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hibernate_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //创建 jdbcTemplate 对象 ，设置数据源
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        //调用 jdbcTemplate 里面的 方法 实现 delete 方法
        String sql="delete from user where username=?";
        int rows=jdbcTemplate.update(sql,"lucy");
        System.out.println(rows);
    }


    //删除操作
    @Test
    public void delete() {
        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///hibernate_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //创建 jdbcTemplate 对象 ，设置数据源
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

        //调用 jdbcTemplate 里面的 方法 实现 update 方法
        String sql="update user set password=? where username=?";
        int rows=jdbcTemplate.update(sql,"1314","lucy");
        System.out.println(rows);
    }






}




