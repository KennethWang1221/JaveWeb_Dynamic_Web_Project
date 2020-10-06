package cn.itcast.hibernatetest;

import cn.itcast.entity.Customer;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class HibernateSearch {
    /*
    * 演示 hibernate 中 检索策略
    * */

    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;

    // 立即查询
    @Test
    public void testSearch() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            //根据 id=1 客户

            /*
            * 执行 get 方法之后，是否发送sql语句？
            * 调用get 方法马上发送sql语句查询数据库
            * */
            Customer customer=session.get(Customer.class,1);

            System.out.println(customer.getCid());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

    //延迟查询
    @Test
    public void testSearch2() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            //根据 id=1 客户

            /*
            * 1 调用 load 方法之后，不会马上发送sql 语句
            *  （1）返回对象里面只有 id 值
            * 2 得到对象里面不是 id （代码68句）的其他值时才会发送通知
            *
            * */

            Customer customer=session.load(Customer.class,2);

            System.out.println(customer.getCid());
            System.out.println(customer.getCustName());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

}
