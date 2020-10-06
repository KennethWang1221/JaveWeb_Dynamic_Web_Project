package com.ch7.Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest1 {
    /*
    * set接口和list接口的主要区别有两个：
    * 1 list的存储顺序和放置顺序一致，set的存储顺序和放置顺序无关
    * 2 list 集合对象可以重复放入对象，set存放对象时不允许重复
    * */

    public static void main(String[] args) {
        /*
        * hashset 是用对象的hashcode方法计算哈希值，根据这个值确定内存位置。
        *
        * */

        HashSet hs1=new HashSet();
        hs1.add("book");
        hs1.add("java");
        hs1.add("c++");
        hs1.add("tiger");

        //添加一个已经存放过的对象

        hs1.add("java");
       // System.out.println(hs1);
        //由于存储顺序和放入的顺序不一致，所以不能根据索引获取内容
        Iterator it=hs1.iterator();

        while(it.hasNext()) {
            Object o1=it.next();
            System.out.println(o1);
        }
    }
}
