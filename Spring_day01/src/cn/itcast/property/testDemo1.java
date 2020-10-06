package cn.itcast.property;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
* 使用有参数构造注入属性
*
* */
public class testDemo1 {

    @Test
    public void testDemo1() {
        // 1 加载Spring 配置文件，根据配置文件创建对象
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");

        // 2 得到配置创建的对象
        PropertyDemo1 demo1= (PropertyDemo1) context.getBean("demo");
        demo1.test1();
    }
}
