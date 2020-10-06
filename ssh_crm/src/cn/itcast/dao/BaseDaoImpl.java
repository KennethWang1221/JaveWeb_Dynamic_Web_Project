package cn.itcast.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class pClass;
    //构造方法
    public BaseDaoImpl() {
        //第一步 得到当前运行类 Class  （就是 得到 CustomerDaoImpl 这个类的对象）
        Class clazz=this.getClass();//这个方法 是 object 类 里边的方法

        System.out.println("******"+clazz);

        //第二步 得到运行类父类的 参数化类型 BaseDaoImpl<Customer>
        //Type getGenericSuperclass()
        Type type=clazz.getGenericSuperclass();
        //使用 Type 子接口 ParameterizedType
        ParameterizedType ptype= (ParameterizedType) type;
        System.out.println("*******"+ptype);

        //第三步 得到实际类型参数 <Customer> 里面的 Customer
        Type[] types =ptype.getActualTypeArguments();
        //Type 接口实现类 Class
        Class tclass= (Class) types[0];
        System.out.println("*****"+pClass);
        this.pClass=tclass;
    }

    //添加
    @Override
    public void add(T t) {
        this.getHibernateTemplate().save(t);
    }

    //修改
    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    //删除
    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    //根据ID 查询
    @Override
    public T findOne(int id) {
        //不能写 T.class
        //this.getHibernateTemplate().get(T.class,id);

        return (T) this.getHibernateTemplate().get(pClass,id);
    }

    //查询所有
    @Override
    public List<T> findAll() {
        //使用 Class 里面 getSimpleName() 得到类名称
        //也没有下面这种写法
        //this.getHibernateTemplate().find("from"+T);

        //使用 Class 里面 getSimpleName() 得到类名称

        return (List<T>) this.getHibernateTemplate().find(" from "+pClass.getSimpleName());
    }
}
