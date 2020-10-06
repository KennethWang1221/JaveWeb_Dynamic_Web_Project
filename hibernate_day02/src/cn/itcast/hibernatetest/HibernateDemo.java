package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class HibernateDemo {
    // 查询代码
    @Test
    public void testGet() {
        // 1 调用工具类得到 sessionFactory
        SessionFactory sessionFactory= HibernateUtils.getSessionFactory();

        //2 获取session
        Session session=sessionFactory.openSession();
        //3 开启事务
        Transaction tx=session.beginTransaction();

        //4 根据 ID 查询
        // 调用session里面的get 方法
        //第一个参数 实体类的class
        //第二个参数 id值
        User user=session.get(User.class,1);//此对象就是 持久态

        System.out.println(user);


        //瞬时态演示 瞬时态 一般都做的是save的操作
        /*User u=new User();
        u.setUsername("jack");
        u.setPassword("444");
        u.setAddress("泰国");

        //以上四行 都是 瞬时态 因为和session 没有任何关联, 加了下面一行才是和session有了关联
        session.save(u);*/






        //5 提交事务
        tx.commit();
        //6 关闭
        session.close();
        sessionFactory.close();
    }

    //修改代码 方法一  一般都使用此方法进行修改，方法二基本不实用
    @Test
    public void testModify() {
        // 1 调用工具类得到 sessionFactory
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();

        // 2 获取session
        Session session=sessionFactory.openSession();

        // 3 开启事务
        Transaction tx=session.beginTransaction();

        // 4 修改操作
        // 修改 uid=2 记录的 username值
        // 4.1 要想修改某一记录中的值 必须先查询
        /*User user=session.get(User.class,2);
        // 4.2 向返回的user对象里面设置修改之后的值
        user.setUsername("东方不败");
        // 4.3 调用session中的 方法 update 修改
        //执行过程，到user对象里面找到uid值，根据 uid 进行修改
        session.update(user);*/

        //验证 hibernate 一级缓存特性
        // 1 根据id查询
        User user=session.get(User.class,5);
        user.setUsername("hanmeimei");
        //不需要使用调用update方法再去实现,因为持久态自动更新数据库
        //session.update(user);

        // 5 提交事务
        tx.commit();
        // 6 关闭
        session.close();
        sessionFactory.close();
    }

    //修改代码 方法二 一般不建议这么写，基本都是使用方法一进行修改操作
    @Test
    public void testModify2(){
        // 1 调用工具类得到sessionFactory
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        // 2 获取session
        Session session=sessionFactory.openSession();
        // 3 开启事务
        Transaction tx=session.beginTransaction();
        // 4 具体操作-修改方法二
        User user=new User();
        user.setUid(1);
        user.setUsername("杨过");
        session.update(user);


        // 5 提交事务
        tx.commit();
        // 6 关闭
        session.close();
        sessionFactory.close();
    }







    //删除代码
    @Test
    public void testDelete() {
        // 1 调用工具类得到 sessionFactory
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();

        // 2 获取session
        Session session=sessionFactory.openSession();

        // 3 开启事务
        Transaction tx=session.beginTransaction();

        // 4 删除操作
        // 有两种方式得到 传入 delete()中所需要的对象
        // 第一种 根据 id 查询对象
        User user=session.get(User.class,2);
        session.delete(user);
        // 第二种 方式删除
        /*User user2=new User();
        user2.setUid(3);
        //以上三行的user为托管态

        session.delete(user2);*/

        // 5 提交事务
        tx.commit();
        // 6 关闭
        session.close();
        sessionFactory.close();
    }

    // 增加方法
    @Test
    public void testSaveOrUpdate(){
        // 1 调用 工具类 得到 sessionFactory
        SessionFactory sessionFactory=HibernateUtils.getSessionFactory();
        // 2 获取 session
        Session session=sessionFactory.openSession();
        // 3 开启事务
        Transaction tx=session.beginTransaction();
        // 4 增加操作
        /*User user=new User();
        user.setUid(1);//设不设置uid 都没有关系，因为这个表中已经设置了自动增长
        user.setUsername("岳不群");
        user.setPassword("333");
        user.setAddress("越南");

        session.save(user);*/


        //测试 saveorupdate 方法
        /*User user=new User();
        user.setUsername("jack");
        user.setPassword("888");
        user.setAddress("朝鲜");

        //实体类对象状态是瞬时态，则 saveorupdate 执行 添加操作
        session.saveOrUpdate(user);
*/

        //测试 saveorupdate 方法
        /*User user=new User();
        user.setUid(4);
        user.setUsername("rose");
        user.setPassword("432");
        user.setAddress("阿尔巴尼亚");*/

        //实体类对象是托管态，则 saveorupdate 执行 更新操作
        //session.saveOrUpdate(user);

        //测试saveorupdate 方法
        User user=session.get(User.class,5);
        user.setUsername("lilei");

        //实体类对象是持久态 ，则修改
        session.saveOrUpdate(user);

        // 5 提交事务
        tx.commit();
        // 6 关闭
        session.close();
        sessionFactory.close();



    }







}
