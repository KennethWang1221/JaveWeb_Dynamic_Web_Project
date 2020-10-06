package com.ch7.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {
    public static void main(String[] args) {
        Map map1=new HashMap();

        map1.put("a","book1");
        map1.put("b","book2");
        map1.put("c","book3");

        //如果添加元素是，key重复（判断依据是对象的equals和hashcode方法）
        map1.put("c","tiger");

        Object o2=map1.get("b");

        //遍历map集合
        // 1 先获取所有的key集合 ，然后根据key一个个的取值
        Set keySet=map1.keySet();
        //迭代器
        /*Iterator it=keySet.iterator();
        while(it.hasNext()) {
            Object key=it.next();//获取一个个的key值
            Object v=map1.get(key);
            System.out.println(v);//自动调用tostring方法
        }*/

        Iterator it=keySet.iterator();
        while(it.hasNext()) {
            Object key=it.next();
            Object v=map1.get(key);
            System.out.println(v);
        }

      System.out.println("************");

        //通过map集合对象中的key-value映射关系，进行遍历
        Set enset=map1.entrySet();
        Iterator it2=enset.iterator();

        while(it2.hasNext()) {
            //获取map中每个元素的k-v映射关系
            Map.Entry en=(Map.Entry)it2.next();
            //根据每个元素的映射关系，获取k和v
            Object k=en.getKey();
            Object v=en.getValue();
            System.out.println("key:"+k+" value:"+v);
        }

    }
}
