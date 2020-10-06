package cn.itcast.xmlano;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testxmlano {
    @Test

    public void testService() {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean2.xml");

        BookService bookService= (BookService) context.getBean("bookService");
        bookService.add();
    }
}
