package cn.itcast.hibernatetest;

import cn.itcast.entity.Customer;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateManyTable {
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;


    //测试 内连接  Customer  c  inner  join  c.setLinkMan（在客户中 怎么表示联系人？使用联系人的set 集合）
    @Test
    public void testSelect1() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建query 对象
            Query query=session.createQuery("from Customer c inner join c.setLinkMan");
            List list=query.list();


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

    //测试 迫切内连接
    @Test
    public void testSelect2() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建query 对象
            Query query=session.createQuery("from Customer c inner join fetch c.setLinkMan");
            List list=query.list();


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }


    // 测试 迫切左外连接
    @Test
    public void testSelect3() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建query 对象
            Query query=session.createQuery("from Customer c left outer join  c.setLinkMan");
            List list=query.list();


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

    //测试 右连接
    @Test
    public void testSelect4() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建query 对象
            Query query=session.createQuery("from Customer c right join  c.setLinkMan");
            List list=query.list();


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }


}
