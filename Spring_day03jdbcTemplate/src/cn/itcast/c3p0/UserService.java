package cn.itcast.c3p0;

public class UserService {

    /*
    * service 里边 调用 dao ，然后 dao 里边 用模版 做操作
    *
    * */

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }

    public void add() {
        userDao.add();
    }

}
