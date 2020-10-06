package cn.itcast.property;


/*
* 使用有参数构造注入属性
* */
public class PropertyDemo1 {
    private String username;



    //有参构造
    public PropertyDemo1(String username) {
        this.username = username;
    }

    public void test1() {
        System.out.println("deom1中的："+username);
    }
}
