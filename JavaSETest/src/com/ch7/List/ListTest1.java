package com.ch7.List;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListTest1 {
    public static void main(String[] args){
        List li=new ArrayList();
        //给li集合添加元素，当没有使用泛型限制时，添加的类型是object
        li.add(5);
        li.add("book");
        li.add(new Date());
        li.add(new ListTest1());
        li.add(new JFrame("一个窗口"));

        //获取第三次放入的对象
        Date md1=(Date)li.get(2);
        System.out.println(md1);

        JFrame jf= (JFrame) li.get(4);
        jf.setVisible(true);

        li.add("abc");
        li.add("def");
        li.add("book");
        li.add("abc");
        li.add("java");

        //list的对象可以像数组一样用索引值遍历
        for(int i=0;i<li.size();i++){
            String str= (String) li.get(i);
            System.out.println(str);
        }
    }
}
