package com.ch7.List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest1 {
    public static void main(String[] args){
        LinkedList lst1=new LinkedList();
        List lst2=new LinkedList();
        /*
        * lst1 类型是具体的，所以赋值时限制大
        * lst2 类型是接口，后期可以赋值为任意的实现类，更灵活
        * */

        lst1.add("book");
        lst1.add(5);//自动装箱
        lst1.add("this");
        lst1.add("tiger");
        lst1.add("lion");
        lst1.add("dog");
        lst1.add("this");

        Object o5=lst1.get(4);
        //遍历
        for (int i=0;i<lst1.size();i++) {
            Object o1=lst1.get(i);
            System.out.print(o1);//调用tostring方法，按照多态的原则
        }

        System.out.print("==============");

        //foreach循环
        for(Object o2:lst1){
            System.out.print(o2);

        }

        //迭代器，其实就是指向链表头节点的指针
        Iterator it=lst1.iterator();
        //iterator使用时有些神异事项
        //lst1.add("cat");

        while(it.hasNext()) {
            Object o6=it.next();
            String str8=(String)o6;
            //如果遍历时发现值为"lion"，则删除
            if("lion".equals(str8)) {
                //lst1.remove();
                it.remove();
            }
            System.out.println(o6);
        }


    }
}












