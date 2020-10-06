package cn.itcast.hibernatetest;

import cn.itcast.manytomany.Role;
import cn.itcast.manytomany.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class HibernateManytoMany {

    /*
    * 多对多的级连的保存
    * */
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;
    @Test
    public void testSave() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            //1添加两个用户，三个角色，为每个用户添加两个角色
            User user1=new User();
            user1.setUser_name("lucy");
            user1.setUser_password("123");

            User user2=new User();
            user2.setUser_name("mary");
            user2.setUser_password("134");

            //添加两个角色
            Role r1=new Role();
            r1.setRole_name("总经理");
            r1.setRole_memo("总经理");

            Role r2=new Role();
            r2.setRole_name("秘书");
            r2.setRole_memo("秘书");

            Role r3=new Role();
            r3.setRole_name("保安");
            r3.setRole_memo("保安");

            //2 建立关系 利用代码模拟多对多的关系，把角色放到用户里面
            //user1--r1/r2
            user1.getSetRole().add(r1);
            user1.getSetRole().add(r2);

            //user2--r2/r3
            user2.getSetRole().add(r1);
            user1.getSetRole().add(r3);

            // 3 保存用户
            session.save(user1);
            session.save(user2);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

    /*
    * 级连删除
    * */

    @Test
    public void testDelete() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            //级连 删除
            User user=session.get(User.class,2);
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tx.rollback();
        }
    }

    /*
    * 维护第三张表 比如 给用户添加角色，给用户移除角色
    * */
    @Test
    public void testTable() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            //让某个用户具有某个角色
            // 让 Lucy 具有经纪人的角色
            // 1 查询Lucy和经纪人
            User lucy=session.get(User.class,1);
            Role role=session.get(Role.class,5);

            // 2 把角色放到用户的set集合里面, 以此实现 让某个用户有某个角色
            lucy.getSetRole().add(role);



            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {


        }
    }

    /*
     * 维护第三张表 比如 给用户移除角色
     * */
    @Test
    public void testTable2() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            //让某个用户没有某个角色
            User user=session.get(User.class,1);
            Role role=session.get(Role.class,3);

            // 2 从用户 1 里边 去掉 他的 3 这个角色
            user.getSetRole().remove(role);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }



}
