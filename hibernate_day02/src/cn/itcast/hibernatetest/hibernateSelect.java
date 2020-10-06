package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;


//验证hibernate一级缓存机制
public class hibernateSelect {
    @Test
    public void testCash() {
        // 1 调用工具类得到 sessionFactory
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();

        // 2 获取session
        Session session=sessionFactory.openSession();
        // 3 开启事务
        Transaction tx=session.beginTransaction();
        // 4 具体的操作

        // 1 根据uid=6查询
        User user=session.get(User.class,5);
        System.out.println(user);

        // 2 根据uid=6 再次查询
        User user2=session.get(User.class,5);
        System.out.println(user2);






        // 5 提交事务
        tx.commit();
        // 6 关闭session
        session.close();
        sessionFactory.close();
    }
}
