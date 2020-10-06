package cn.itcast.dao;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDaoImpl implements UserDao {



    //得到hibernateTemplate 对象
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate=hibernateTemplate;
    }


    public void add() {
        System.out.println("userdaoimpl add....");
        //hibernateTemplate 对 hibernate 进行封装
        //HibernateTemplate hibernateTemplate=new HibernateTemplate();


        User user=new User();
        user.setUsername("rose");
        user.setAddress("japan");

        //调用 save 方法实现添加
        hibernateTemplate.save(user);

    }

}
