package cn.itcast.ioc;

import cn.itcast.property.PropertyDemo1;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUser {

    @Test
    public void testDemo1() {
        // 1 加载Spring 配置文件，根据配置文件创建对象
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2 得到配置创建的对象
        UserService userService= (UserService) context.getBean("userService");
        userService.add();
    }
}
