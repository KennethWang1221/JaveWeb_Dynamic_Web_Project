package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateQuery {
    // 使用 query 对象
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;
    @Test
    public void testSelect() {
        try {
            // 1 调用工具类得到 sessionFactory
            sessionFactory= HibernateUtils.getSessionFactory();

            // 2 获取session
            session=sessionFactory.openSession();

            // 3 开启事务
            tx=session.beginTransaction();

            // 4 具体操作 使用 hql 语句 查询user表中数据
            // 1 创建query 对象
            Query query=session.createQuery("from User");
            // 2 调用query对象里面的方法得到结果
            List<User> list=query.list();

            //遍历 list 中的 对象或者称之为值
            for (User user:list) {
                System.out.println(user);
            }


            // 5 提交事务
            tx.commit();


        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            // 6 关闭事务
            session.close();
            sessionFactory.close();


        }
    }
}
