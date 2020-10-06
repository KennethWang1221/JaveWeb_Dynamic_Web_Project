package cn.itcast.aop;

import cn.itcast.xmlano.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @Test

    public void testService() {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean3.xml");

        Book book= (Book) context.getBean("book");
        book.add();
    }
}
