package com.ch7.Set;

import java.util.TreeSet;

public class TreeSetTest1 {
    public static void main(String[] args) {
        TreeSet ts=new TreeSet();
        ts.add("lion");
        ts.add("java");
        ts.add("cat");
        ts.add("dog");

        System.out.println(ts);

        /*
        * TreeSet 的存储顺序是对放入的对象，进行比较（比大小），按照从小到大
        * 的顺序存放。如果是自定义的类型，想用tree set的对象进行排序存放，则必须实现comparable
        * 重写compareto方法
        * */

    }
}
