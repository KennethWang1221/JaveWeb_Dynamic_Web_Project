package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class HibernateSelectDemo {
    //事务规范代码写法
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

            // 4 具体操作
            //添加
            /*User user=new User();
            user.setUsername("赵老大");
            user.setPassword("746");
            user.setAddress("韩国");*/

            //session.save(user);

            User user=session.get(User.class,7);
            System.out.println(user);


            //int i=10/0;
            //测试 若发生异常了，该怎么办，若发生异常，则不执行try下边的语句 进入catch中
            //执行 catch中的具体操作，详情见Javase 基础知识讲解

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
