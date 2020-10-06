package cn.itcast.dao;

import cn.itcast.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {



    //得到hibernateTemplate 对象
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate=hibernateTemplate;
    }


    public void add() {
        //System.out.println("userdaoimpl add....");
        //hibernateTemplate 对 hibernate 进行封装
        //HibernateTemplate hibernateTemplate=new HibernateTemplate();


        /*User user=new User();
        user.setUsername("lili");
        user.setAddress("korean");

        //调用 save 方法实现添加
        hibernateTemplate.save(user);*/

        //get 方法,根据 id 查询
        User user=hibernateTemplate.get(User.class,2);
        System.out.println(user.getUsername()+"::" + user.getAddress());

        // 2 find 方法查询所有记录
        //List<User> list= (List<User>) hibernateTemplate.find("from User");



    }

}
