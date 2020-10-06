package cn.itcast.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //得到jdbcTemplate 对象
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    public void add() {
        System.out.println("UserDao 中的 add 方法。。。。。。。");

        String sql="insert into user values(?,?)";
        jdbcTemplate.update(sql,"林飞","353");

    }
}
