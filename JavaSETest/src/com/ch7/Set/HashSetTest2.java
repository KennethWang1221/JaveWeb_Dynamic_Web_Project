package com.ch7.Set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest2 {
    public static void main(String[] args) {
        HashSet hs=new HashSet();

        //添加自定义类型的对象
        hs.add(new Animal(2,"tiger"));
        hs.add(new Animal(3,"dog"));
        hs.add(new Animal(4,"cat"));
        hs.add(new Animal(2,"tiger"));


        Iterator it=hs.iterator();
        while(it.hasNext()) {
            Object o1=it.next();
            System.out.println(o1);
        }

    }


    /*
    * set的对象不允许重复存在的对象，对象怎样就重复了？
    * 是依靠对象的equals和hashcode两个方法去判断的
    * */

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
