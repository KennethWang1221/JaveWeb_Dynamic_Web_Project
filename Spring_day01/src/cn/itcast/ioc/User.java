package cn.itcast.ioc;

public class User {
    private String username;

    public User () {

    }

    public User (String username){
        this.username=username;
    }
    public void add() {
        System.out.println("add.........");
    }

    public static void main(String[] args) {
        //原始方法，
        //现在使用了Spring 框架，就不在需要这样的原始方法，但是底层还是反射机制，只是我们不需要写反射代码
        User user=new User();
        user.add();
    }
}
