package cn.itcast.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

    @Test
    public void testDemo() {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");
        OrdersService ordersService= (OrdersService) context.getBean("ordersService");
        ordersService.accountMoney();

    }
}
