package cn.itcast.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

    //添加客户功能
    /*public void add(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }*/

    //客户列表功能
    @SuppressWarnings("all")
    /*public List<Customer> findAll() {
        return (List<Customer>) this.getHibernateTemplate().find("from Customer");
    }*/

    //根据id查询
    /*public Customer findOne(int cid) {
        return this.getHibernateTemplate().get(Customer.class, cid);
    }*/

    //删除功能
    /*public void delete(Customer c) {
        this.getHibernateTemplate().delete(c);
    }*/

    //修改功能
    /*public void update(Customer customer) {
        this.getHibernateTemplate().update(customer);
    }*/

    //查询记录数
    //@SuppressWarnings("all")
    public int findCount() {
        //调用hibernateTemplate里面的find方法实现
        List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
        //从list中把值得到
        if(list != null && list.size()!=0) {
            Object obj = list.get(0);
            //变成int类型
            Long lobj = (Long) obj;
            int count = lobj.intValue();
            return count;
        }
        return 0;
    }




    //分页查询操作
    @Override
    public List<Customer> findPage(int begin, int pageSize) {
        //第一种 使用hibernate底层代码实现（了解）
        //得到sessionFactory
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
        //得到session对象
//		Session session = sessionFactory.getCurrentSession();
        //设置分页信息
//		Query query = session.createQuery("from Customer");
//		query.setFirstResult(begin);
//		query.setMaxResults(pageSize);
//		List<Customer> list = query.list();

        //第二种 使用离线对象和hibernateTemplate的方法实现
        //1 创建离线对象，设置对哪个实体类进行操作
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        //调用hibernateTemplate的方法实现
//		第一个参数是离线对象
//		第二个参数是开始位置
//		第三个参数是每页记录数
        List<Customer> list =
                (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
        return list;
    }

    //条件查询
    @SuppressWarnings("all")
    public List<Customer> findCondition(Customer customer) {
        //第一种方式：
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
        //得到session对象
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from Customer where custName like ?");
//		query.setParameter(0, "%"+customer.getCustName()+"%");
//		List<Customer> list = query.list();

        //第二种方式 ： 调用hibernateTemplate的find方法实现
//		List<Customer> list = (List<Customer>) this.getHibernateTemplate().
//			find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
        //拼接hql语句实现


        //第三种方式
        // 1 创建离线对象，设置对哪个实体类进行操作
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
        // 2 设置对实体类哪个属性
        criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
        // 3 调用hibernateTemplate里面的方法得到list集合
        List<Customer> list =
                (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }



    /*
    //第二种 使用hibernate模板里面find方法实现
    @SuppressWarnings("all")
    //多条件组合查询
    @Override
    public List<Customer> findMoreConditon(Customer customer) {
        //使用 hibernate 模版里面find 方法实现
        //拼接 hql 语句
        String hql="from Customer where 1=1";


        *//*重要的 实现思想，就是 在if 条件中 ，将符合条件的值放到 list 集合中
        否则就不放进去，下例就是 ，值不为空 才方到list 里边去，为空 就不放进去
        创建 list 集合 ，如果值不为空，把值设置到list 里面*//*
        List<Object> p=new ArrayList<Object>();

        //判断条件是否为空，如果不为空拼接hql语句
        if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
            hql+=" and custName=?";
            //把值设置到 list 里面去
            p.add(customer.getCustName());
        }
        if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())) {
            hql+=" and custLevel=?";
            p.add(customer.getCustLevel());
        }
        if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())) {
            hql+=" and custSource=?";
            p.add(customer.getCustSource());
        }


        System.out.println("hql : "+hql);
        System.out.println("list : "+p);

        return (List<Customer>) this.getHibernateTemplate().find(hql,p.toArray());
    }
*/



    //第三种 使用离线对象和hibernate模板里面方法
    @SuppressWarnings("all")
    @Override
    public List<Customer> findMoreConditon(Customer customer) {

        //创建离线对象，指定对哪个实体类进行操作
        DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);

        //判断条件是否为空
        if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
            //设置对 实体类中的属性，设置值
            criteria.add(Restrictions.eq("custName",customer.getCustName()));
        }

        if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())) {
            criteria.add(Restrictions.eq("custLevel",customer.getCustLevel()));
        }

        if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())) {
            criteria.add(Restrictions.eq("custSource",customer.getCustSource()));
        }


        return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
    }
}


