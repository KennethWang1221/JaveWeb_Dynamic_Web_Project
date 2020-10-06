/*
package com.ch3.Student;

public class StudentTest1 {
    */
/*
    * 面向对象设计中的封装，有两层含义。
    * 1 设计类时，将需要的属性和方法进行包装
    * 2 在类中对变量或方法进行权限限制
    * （也就是说 在类中设计的变量，应该限制或避免在类的外部随意访问）
    * *//*


    //设计一个大学生的学生类
    String name=null;
    int grade;
    //如果对变量的访问加了private权限,则需要在类中定义方法去访问
    private int age;

    public void setAge(int age) {
        if(age>=130 && age<=0) {
            System.out.println("输入数据有误");
        }else {
            this.age=age;
        }
    }

    public int getAge() {
        return age;
    }

    //如果需要在创建对象的时候，就进行一个初始化工作，则需要自定义构造方法
    public StudentTest1(String name,int grade) {
        this.name=name;
        this.grade=grade;
    }

    //上面的方法是定义了一个g的成绩值，不是年龄 而在实例化的时候
    public void intro() {
        System.out.print("age="+this.age+" name="+this.name+" grade="+this.grade);
    }

}
*/


package com.ch3.Student;

public class StudentTest1 {
    //编写一个student的user类
    private String name=null;
    private String sex=null;

    private String subject;
    private int age;
    private int rank;





    public StudentTest1(String name,String sex) {
        this.name=name;
        this.sex=sex;
    }

    public void setAge(int age) {
        if(this.age>100 && this.age<=0) {
            System.out.println("输入数据有误！");
        }else{
            this.age=age;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setRank(int rank) {
        this.rank=rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setSubject(String subject) {
        this.subject=subject;
    }

    public String getSubject() {
        return this.subject=subject;
    }


    public void intro() {
        System.out.println("我是"+this.name+" 我今年"+this.age+"岁 "+this.subject+" 我的排名是："+this.rank);
    }


}

/*
package com.ch3.Student;

public class StudentTest1 {
    //编写一个student的user类
    private String name=null;
    private String sex=null;

    private String subject;
    private int age;
    private int rank;


    public StudentTest1(String name) {
        this.name=name;
        System.out.println("一个参数的构造方法调用了");
    }


    public StudentTest1(String name,String sex) {
        this.name=name;
        this.sex=sex;
        System.out.println("两个参数的构造方法调用了");
    }

    *//*
    * 定义两个重载的方法
    * *//*
    public void init(String name) {
        this.name=name;
        System.out.println("一参普通方法调用了");
    }

    public void init(String name,String sex) {

        //两个参数的赋值因为前面已经有了一个参数赋值方法了
        this.init(name);
        this.sex=sex;
        System.out.println("两参普通方法调用了");
    }



    public void setAge(int age) {
        if(this.age>100 && this.age<=0) {
            System.out.println("输入数据有误！");
        }else{
            this.age=age;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setRank(int rank) {
        this.rank=rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setSubject(String subject) {
        this.subject=subject;
    }

    public String getSubject() {
        return this.subject=subject;
    }


    public void intro() {
        System.out.println("我是"+this.name+" 我是："+this.sex+"我今年"+this.age+"岁 "+this.subject+" 我的排名是："+this.rank);
    }


}*/


















