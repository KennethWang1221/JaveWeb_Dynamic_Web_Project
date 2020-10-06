package cn.itcast.hibernatetest;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class HibernateDemo {
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;

    //演示对象导航查询
    @Test
    public void testSelect() {
        try {
            // 1 调用工具类得到 sessionFactory
            sessionFactory=HibernateUtils.getSessionFactory();
            // 2 获得session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 执行相关操作

            //根据 cid=1 客户 ，再查询这个客户里面所有联系人
            Customer customer=session.get(Customer.class,1);
            //再查询这个客户里面所有联系人
            //直接得到客户里面所有联系人的set集合
            Set<LinkMan> linkMan=customer.getSetLinkMan();

            System.out.println(linkMan.size());



            // 5 提交
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }
}
