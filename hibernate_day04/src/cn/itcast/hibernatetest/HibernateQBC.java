package cn.itcast.hibernatetest;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class HibernateQBC {
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;

    // 使用 QBC 查询所有
    @Test
    public void testQBC1() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建对象
            Criteria criteria=session.createCriteria(Customer.class);

            // 2 调用方法 得到结果
            List<Customer> list=criteria.list();

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

    // 使用 QBC 进行 有条件查询
    @Test
    public void testQBC2() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建对象，指定对哪个实体类进行操作，里边写的是实体类的class
            Criteria criteria=session.createCriteria(Customer.class);

            // 2 使用criteria 对象里面的方法设置条件值
            // 首先使用add 方法，表示设置条件值
            // 在 add 方法里面 使用类的方法实现条件设置
            // 类似于 cid=? 下面一行代码 就相当于 在 HibernateHQL.java 第69-81 行代码
            criteria.add(Restrictions.eq("cid",1));
            criteria.add(Restrictions.eq("custName","传智播客"));

            List<Customer> list=criteria.list();
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



    // 使用 QBC 进行 有模糊查询
    @Test
    public void testQBC3() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建对象，指定对哪个实体类进行操作，里边写的是实体类的class
            Criteria criteria=session.createCriteria(Customer.class);

            // 2 设置对哪个属性进行排序，设置排序规则
            criteria.addOrder(Order.asc("cid"));

            // 3 调用方法得到结果
            List<Customer> list=criteria.list();
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



    // 使用 QBC 进行 进行排序
    @Test
    public void testQBC4() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建对象，指定对哪个实体类进行操作，里边写的是实体类的class
            Criteria criteria=session.createCriteria(Customer.class);

            // 2 使用criteria 对象里面的方法设置条件值
            // 首先使用add 方法，表示设置条件值
            // 在 add 方法里面 使用类的方法实现条件设置
            // 类似于 cid=? 下面一行代码 就相当于 在 HibernateHQL.java 第69-81 行代码

            List<Customer> list=criteria.list();
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


    // 使用 QBC 进行 分页查询 sql 中的语句是：select * from t_customer limit 0,3;
    @Test
    public void testQBC5() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建对象，指定对哪个实体类进行操作，里边写的是实体类的class
            Criteria criteria=session.createCriteria(Customer.class);

            // 2 设置分页数据
            // 2.1 设置开始位置
            criteria.setFirstResult(0);
            // 2.2 每页显示记录数
            criteria.setMaxResults(3);
            //3 调用方法得到结果

            List<Customer> list=criteria.list();

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


    // 使用 QBC 进行 离线查询 (没有session 关联，也能执行操作)
    @Test
    public void testQBC6() {
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();

            // 1 创建对象，指定对哪个实体类进行操作，里边写的是实体类的class
            //Criteria criteria=session.createCriteria(Customer.class);

            // 1 创建离线对象
            DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
            Criteria criteria=detachedCriteria.getExecutableCriteria(session);

            //3 调用方法得到结果
            List<Customer> list=criteria.list();
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


    // 使用 QBC 查询 进行 批量抓取 此操作 可以减少语句的发送 应用场景：先得到客户在得到所有联系人
    @Test
    public void testQBC7() {
        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session=sessionFactory.openSession();
            tx=session.beginTransaction();
            //查询所有客户
            Criteria criteria=session.createCriteria(Customer.class);
            List<Customer> list=criteria.list();

            //得到每个客户里面所有的联系人
            for(Customer customer:list) {
                System.out.println(customer.getCid()+"::"+customer.getCustName());
                //每个客户里面所有的联系人  方式：对象导航查询
                Set<LinkMan> linkManSet=customer.getSetLinkMan();
                for(LinkMan linkMan:linkManSet) {
                    System.out.println(linkMan.getLkm_id()+"::"+linkMan.getLkm_name());
                }
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }




}
