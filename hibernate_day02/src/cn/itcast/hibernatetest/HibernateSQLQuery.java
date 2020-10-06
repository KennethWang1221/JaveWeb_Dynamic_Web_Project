package cn.itcast.hibernatetest;

import cn.itcast.entity.User;
import cn.itcast.utils.HibernateUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HibernateSQLQuery {
    //使用 SQLQuery 对象 进行 查询 user表中的数据
    SessionFactory sessionFactory=null;
    Session session=null;
    Transaction tx=null;
    @Test
    public void testSQLQuery() {
        try {
            // 1 调用工具类得到sessionFactory
            sessionFactory= HibernateUtils.getSessionFactory();
            // 2 获得 session
            session=sessionFactory.openSession();
            // 3 开启事务
            tx=session.beginTransaction();
            // 4 具体的操作
            // 4.1 创建对象
            SQLQuery sqlQuery =session.createSQLQuery("select * from t_user");
            // 调用sqlQuery 里面的方法
            // 返回list 集合，默认里面每部分数组结构
            /*List<Object []> list=sqlQuery.list();

            for(Object[] objects : list) {
                //System.out.println(objects);//这样输出的是数组的地址 不满足 直接输出数组的需求

                System.out.println(Arrays.toString(objects));//Arrays.toString()把数组作为字符串输出，
            }*/

            // 1 创建对象  返回list集合，设置里面是 对象结构  使用对象输出好处是：取值方便，用数组取值得加个toString 比较麻烦
            // 参数是普通sql语句

            SQLQuery sqlQuery1=session.createSQLQuery("select * from t_user");

            //下边这句代码的功能是 ： 使返回的list中每部分是对象形式   表示设置你的数据封装到哪个实体类中
            sqlQuery1.addEntity(User.class);

            //调用sqlQuery 里面的方法
            List<User> list=sqlQuery1.list();
            System.out.println("以下是 利用 list返回对象形式 输出的数据");
            for(User user:list) {
                System.out.println(user);
            }

            // 5 提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
        }
    }
}
