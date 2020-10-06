package cn.itcast.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    static Configuration cfg =null;
    static SessionFactory sessionFactory=null;
    //静态代码块实现
    static {
        //加载核心配置文件
        cfg=new Configuration();
        cfg.configure();
        sessionFactory=cfg.buildSessionFactory();
    }

    //提供方法返回sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
