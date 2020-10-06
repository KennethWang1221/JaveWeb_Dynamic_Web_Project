package cn.itcast.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestIoc {
    @Test
    public void testUser() {
        // 1 加载 Spring 配置文件 根据配置文件创建对象
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");

        //2 得到配置创建的对象
        User user= (User) context.getBean("user");
        System.out.println(user);
        user.add();

    }

}
