package cn.itcast.property;

public class Book {
    private String bookname;

    // get 方法
    public String getBookname() {
        return bookname;
    }

    //set 方法
    public void setBookname(String bookname) {
        this.bookname=bookname;
    }

    public void demobook() {
        System.out.println("Book 类中的 方法输出："+bookname);
    }
}
