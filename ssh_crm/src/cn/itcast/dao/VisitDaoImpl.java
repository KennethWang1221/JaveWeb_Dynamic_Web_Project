package cn.itcast.dao;

import cn.itcast.entity.Visit;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

    //添加客户拜访方法
    @Override
    public void add(Visit visit) {
        this.getHibernateTemplate().save(visit);
    }

    @SuppressWarnings("all")
    //拜访列表的方法
    @Override
    public List<Visit> findAll() {

        return (List<Visit>) this.getHibernateTemplate().find("from Visit");
    }
}
