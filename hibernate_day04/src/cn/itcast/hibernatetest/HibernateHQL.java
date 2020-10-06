package cn.itcast.hibernatetest;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class HibernateHQL {
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;
    //演示查询所有

    @Test
    public void testSelect1() {
        try {
            // 1 调用工具类得到 sessionFactory
            sessionFactory= HibernateUtils.getSessionFactory();
            // 2 获得session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 执行相关操作

            // 1 创建query对象
            Query query=session.createQuery("from Customer");
            // 2 调用方法得到结果
            List<Customer> list=query.list();

            for (Customer customer:list
            ) {
                System.out.println(customer.getCid()+"::"+customer.getCustName());
            }



            // 5 提交
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

    //演示 hql 中 条件查询
    @Test
    public void testSelect2() {
        try {
            // 1 调用工具类得到 sessionFactory
            sessionFactory= HibernateUtils.getSessionFactory();
            // 2 获得session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 执行相关操作

            // 1 创建 Query  对象
            // 在 普通 sql 语句中 的 条件查询语句是：
            // select * from t_customer where cid=? and custName=?
            Query query= session.createQuery("from Customer c where c.cid=? and c.custName=?");

            // 2设置条件值 使用 setParameter();方法
            // 向 ？ 里面设置值
            // setParameter方法有两个参数
            // 第一个参数 ：int 类型是 ： ？的位置 （从0开始）
            // 第二个参数 ：具体的参数值

            // 设置第一个 ？ 值
            query.setParameter(0,2);

            //设置第二个 ？ 值
            query.setParameter(1,"百度");

            // 3 调用方法得到结果
            List<Customer> list= query.list();

            for (Customer customer:list
            ) {
                System.out.println(customer.getCid()+"::"+customer.getCustName());
            }

            // 2 设置条件值



            // 5 提交
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

    // 演示条件查询中的 模糊查询
    @Test
    public void testSelect3() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建 query 对象
            Query query=session.createQuery("from Customer c where c.custName like ?");

            // 2 设置 ？ 的值
            query.setParameter(0,"%浪%");

            // 3 调用方法得到结果
            List<Customer> list=query.list();

            // 4 打印方法
            for(Customer customer : list) {
                System.out.println(customer.getCid()+"::"+customer.getCustName());
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }


    // hql 排序语句写法  sql 中的语句：select * from t_customer order by cid asc;
    @Test
    public void testSelect4() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建 query 对象
            Query query=session.createQuery("from Customer c order by cid desc ");

            List<Customer> list=query.list();
            for(Customer customer:list) {
                System.out.println(customer.getCid()+"::"+customer.getCustName());
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

    // 使用 hql 进行 分页查询  sql 语句： select * from t_customer limit 0,3 (0 开始位置 3 每页记录数)
    @Test
    public void testSelect5() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 使用 hql 查询 所有 分页查询
            // 创建 query 对象
            Query query=session.createQuery("from Customer");

            // 2 设置分页数据
            // 2.1 设置开始位置
            query.setFirstResult(0);
            // 2.2 设置每页 的 记录数
            query.setMaxResults(3);

            // 3 调用方法得到结果
            List<Customer> list=query.list();

            for(Customer customer:list) {
                System.out.println(customer.getCid()+"::"+customer.getCustName());
            }

            System.out.println("");

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }


    //使用 hql 进行 投影查询  Select cusName from t_customer;
    @Test
    public void testSelect6() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            //  使用 hql 查询 投影查询
            // 1 创建 query 对象
            Query query=session.createQuery("select custName from Customer");

            // 调用方法得到 结果
            // 这次 在List<>泛型中不在写 List<Customer> 是因为
            // 这此查询过的结果 返回的是 一个值，不是对象 所以List<Object> 泛型中写 object 刚好
            List<Object> list=query.list();

            for(Object object:list) {
                System.out.println(object);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }


    //演示聚集函数的使用
    @Test
    public void testSelect7() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建 query 对象
            Query query=session.createQuery("select count(*) from Customer ");

            // 2 调用方法得到结果
            // query  对象里面有方法，直接返回对象形式,可以得到里面的某一个值，不再需要里面的list 进行遍历 ---唯一的结果的值
            Object object=query.uniqueResult();
            System.out.println(object);


            //真正的开发中，返回的记录数是int 类型，而不是object类型 先要变成long 类型 再变成 int 类型

            /* 下面两句报错 必须要 先要变成long 类型 再变成 int 类型
            int count=(int)object;
            System.out.println(count);*/
            Long lobj=(Long)object;
            int count=lobj.intValue();//此方法的意思是将 数据转变成 int 类型
            System.out.println(count);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }

}

