package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class hibernateDemo {
   @Test
   public void testAdd() {
//		第一步 加载hibernate核心配置文件
       // 到src下面找到名称是hibernate.cfg.xml
       //在hibernate里面封装对象
       //Configuration cfg = new Configuration();
       //cfg.configure();//加载配置文件

//		第二步 创建SessionFactory对象
       //读取hibernate核心配置文件内容，创建sessionFactory
       //在过程中，根据映射关系，在配置数据库里面把表创建
       //SessionFactory sessionFactory = cfg.buildSessionFactory();//返回sessionfactory对象

       //使用Utils类 方法：将 sessionFactory 对象 抽取出来
       SessionFactory sessionFactory= HibernateUtils.getSessionFactory();


//		第三步 使用SessionFactory创建session对象
       // 类似于jdbc连接conn
       Session session = sessionFactory.openSession();

//		第四步 开启事务
       Transaction tx = session.beginTransaction();

//		第五步 写具体逻辑 crud操s作
       //不需要操作表，只用操作表中实体类对应的对象即可
       //添加功能
       User user = new User();
       user.setUsername("小马");
       user.setPassword("120");
       user.setAddress("中国");
       //调用session的方法实现添加
       session.save(user);

//		第六步 提交事务
       tx.commit();

//		第七步 关闭资源
       session.close();
       sessionFactory.close();
   }



}
