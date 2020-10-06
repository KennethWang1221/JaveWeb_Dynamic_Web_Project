package cn.itcast.ioc;

public class UserService {
    // 1 定义dao 类型属性
    private UserDao userDao;
    // 2 生成set方法
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }

    public void add() {
        System.out.println("service.....");
        /*
        * 如果按照原来的方法 在一个类中 想调用另一个类中的方法，new 另一个类中的对象，然后用new的这个对象去调用方法
        * 则要按照下列的方法实现，
        * */
        /*UserDao dao=new UserDao();
        dao.add();*/

        userDao.add();
    }
}
