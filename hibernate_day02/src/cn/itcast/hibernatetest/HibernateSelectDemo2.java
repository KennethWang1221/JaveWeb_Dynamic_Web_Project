package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;


/*
* 测试 获取本地线程与session绑定
*
* */
public class HibernateSelectDemo2 {
    //SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;
    @Test
    public void testSelect() {
        try {
            // 1调用工具类获得sessionFactory
            //sessionFactory=HibernateUtils.getSessionFactory();
            //与本地线程绑定的session
            session=HibernateUtils.getSessionobject();
            // 2获得session
            //session=sessionFactory.openSession();
            // 3开启事务
             tx=session.beginTransaction();
            // 4添加操作
            User user=new User();
            user.setUsername("马云");
            user.setPassword("alibb");
            user.setAddress("杭州");

            session.save(user);

            // 5提交事务
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            /*与本地线程绑定的session，不需要再次本地关闭了
            因为 已经与线程绑定的session 他俩是一根绳子上的蚂蚱
            所以 线程关闭，session也关闭，这时如果在写下边的关闭代码
            则会报错，如下，显示已经关闭
             org.hibernate.SessionException: Session was already closed

             若写 opensession 方法 未与本地线程绑定 则需要手动关闭session


             */
            //session.close();
            //sessionFactory.close();
        }
    }

}
