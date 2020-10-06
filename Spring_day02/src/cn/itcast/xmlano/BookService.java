package cn.itcast.xmlano;

import javax.annotation.Resource;

public class BookService {

    //要在 BookService 中 得到 bookdao 和 ordersdao 对象
    //配置文件和注解混合使用
    // 使用 配置文件 的方式 进行创建对象
    //使用 注解 的方式 进行 属性注入
    @Resource(name="bookDao")
    private BookDao bookDao;

    @Resource(name="orderDao")
    private OrderDao orderDao;


    public void add() {
        System.out.println("service.......");
        bookDao.book();
        orderDao.buy();
    }

}
