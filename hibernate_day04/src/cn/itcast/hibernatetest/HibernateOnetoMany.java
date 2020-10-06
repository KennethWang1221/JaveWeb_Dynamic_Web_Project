package cn.itcast.hibernatetest;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

public class HibernateOnetoMany {
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;


    @Test
    public void testAddDemo1() {
        /*
    测试 一对多级联保存 （此法二为复杂写法） 添加客户，为这个客户添加一个联系人

*/
        try {
            // 1 调用 工具类 得到 sessionFactory
            sessionFactory=HibernateUtils.getSessionFactory();
            // 2 获得 session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 具体的操作

            // 添加一个客户 ，为这个客户添加一个联系人
            // 4.1 创建客户和联系人对象
            Customer customer=new Customer();
            customer.setCustName("传智播客");
            customer.setCustLevel("vip");
            customer.setCustSource("网络");
            customer.setCustPhone("110");
            customer.setCustMobile("999");


            LinkMan linkMan=new LinkMan();
            linkMan.setLkm_name("lucy");
            linkMan.setLkm_gender("女");
            linkMan.setLkm_phone("911");

            // 4.2 在客户中表示所有的联系人，在联系人中表示
            //建立客户对象和联系人对象关系

            // 4.3 把联系人对象 放到 客户实体类对象的set集合 中
            customer.getSetLinkMan().add(linkMan);

            // 4.4 把客户对象放到联系人里面
            linkMan.setCustomer(customer);

            // 4.5 把数据添加（保存）到数据库中去
            session.save(customer);
            session.save(linkMan);

            // 5 提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void testAddDemo2() {
        /*
        *  使用 方法二 ：简化法 一对多级联保存 添加客户
        * */
        try {
            // 1 调用 工具类 得到 sessionFactory
            sessionFactory=HibernateUtils.getSessionFactory();
            // 2 获得 session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 具体的操作

            // 添加一个客户 ，为这个客户添加一个联系人
            // 4.1 创建客户和联系人对象
            Customer customer=new Customer();
            customer.setCustName("百度");
            customer.setCustLevel("vip");
            customer.setCustSource("广告");
            customer.setCustPhone("223");
            customer.setCustMobile("333");


            LinkMan linkMan=new LinkMan();
            linkMan.setLkm_name("小红");
            linkMan.setLkm_gender("男");
            linkMan.setLkm_phone("111");

            // 4.2 在客户中表示所有的联系人，在联系人中表示
            //建立客户对象和联系人对象关系

            // 4.3 把联系人对象 放到 客户实体类对象的set集合 中
            customer.getSetLinkMan().add(linkMan);

            // 4.4 因为在 customer.hbm.xml 中已经进行了配置所以在简化方法里不再需要 把客户对象放到联系人里面
            // <set name="setLinkMan" cascade="save-update">  此代码的配置 底层代码实质就是此句代码
            //linkMan.setCustomer(customer);

            // 4.5 把数据添加（保存）到数据库中去
            session.save(customer);
            //session.save(linkMan);

            // 5 提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


    @Test
    public void testDeleteDemo() {
        /*
         *  使用 方法二 ：简化法 一对多级联保存 添加客户
         * */
        try {
            // 1 调用 工具类 得到 sessionFactory
            sessionFactory=HibernateUtils.getSessionFactory();
            // 2 获得 session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 具体的操作


            // 4.1  根据id 查询客户对象 ,然后删除查询到的对象
            Customer customer = session.get(Customer.class,4);
            //4.2 调用方法进行删除
            session.delete(customer);


            // 5 提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 回滚
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void testUpdateDemo() {
        /*
         *  使用 方法二 ：简化法 一对多级联保存 修改值
         * */
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tx=null;
        try {
            // 1 使用工具类得到 sessionFactory
            sessionFactory= HibernateUtils.getSessionFactory();
            // 2 得到 session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 具体的操作
            // 4.2 根据ID 查询 Lucy 联系人 ，根据id查询 百度的客户
            Customer baidu=session.get(Customer.class,5);
            LinkMan lucy=session.get(LinkMan.class,1);

            // 4.1 设置 持久态对象值
            // 把联系人放到客户里面
            baidu.getSetLinkMan().add(lucy);
            // 把客户方到联系人里边
            lucy.setCustomer(baidu);




            // 5 提交事务
             tx.commit();




        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }




}
