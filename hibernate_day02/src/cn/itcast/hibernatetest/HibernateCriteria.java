package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateCriteria {
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;
    @Test
    public void testCriteria() {

        try {
            // 1 调用工具类获得 sessionFactory 对象
            sessionFactory=HibernateUtils.getSessionFactory();
            // 2 获得session对象
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 使用 criteria 对 user 表进行查询
            //  4.1创建 query 对象
            Criteria criteria=session.createCriteria(User.class);
            //  4.2调用方法得到结果
            List<User> list=criteria.list();

            System.out.println("这是 使用 Criteria对象 及其 里面的方法 查询 user表中的数据");
            for(User user:list) {

                System.out.println(user);
            }




            // 5 提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            tx.rollback();
        } finally {
        }
    }
}
