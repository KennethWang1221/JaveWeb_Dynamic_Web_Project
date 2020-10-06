package cn.itcast.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

    //添加联系人的方法
    public void add(LinkMan linkMan) {
        this.getHibernateTemplate().save(linkMan);
    }

    //联系人列表的方法
    @SuppressWarnings("all")
    public List<LinkMan> list() {
        return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
    }

    //根据id查询联系人
    public LinkMan findOne(int linkid) {
        return this.getHibernateTemplate().get(LinkMan.class, linkid);
    }

    //修改联系人的方法
    public void update(LinkMan linkMan) {
        this.getHibernateTemplate().update(linkMan);
    }

    //多条件组合查询  第一种方法：使用hql 语句拼接的方式实现
    /*@SuppressWarnings("all")

    @Override
    public List<LinkMan> findCondition(LinkMan linkMan) {
        String hql="from LinkMan where 1=1 ";
        List<Object> p= new ArrayList<Object>();
        //判断条件值是否为空
        if(linkMan.getLinkName()!=null && !"".equals(linkMan.getLinkName())) {
            hql+="and linkName=?";
            p.add(linkMan.getLinkName());
        }
        //判断是否选择客户(判断客户里面的CID值)
        if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0) {
            hql +="and customer.cid=?";
            p.add(linkMan.getCustomer().getCid());
        }
        return (List<LinkMan>) this.getHibernateTemplate().find(hql,p.toArray());
    }*/

    //多条件组合查询  第三种方法：使用离线对象实现查询
    public List<LinkMan> findCondition(LinkMan linkMan) {
        //创建离线对象
        DetachedCriteria criteria=DetachedCriteria.forClass(LinkMan.class);
        //判断条件值是否为空
        if(linkMan.getLinkName()!=null && !"".equals(linkMan.getLinkName())) {
            criteria.add(Restrictions.eq("linkName",linkMan.getLinkName()));
        }
        //判断是否选择客户(判断客户里面的CID值)
        if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0) {
            criteria.add(Restrictions.eq("customer.cid",linkMan.getCustomer().getCid()));
        }


        return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
    }





}
