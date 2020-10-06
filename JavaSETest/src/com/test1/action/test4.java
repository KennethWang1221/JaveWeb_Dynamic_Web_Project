package com.test1.action;

import org.junit.jupiter.api.Test;

import java.util.*;

public class test4 {


    //@Test
    public static void main(String[] args) {
        test4 t4=new test4();
        //t4.judgePrime();
        //t4.PrimeTest();
        int[] arrays=new int[] {2,3,1,0,2,5,3};
        int[] arrays2=new int[] {7,3,4,9,3,2,6,10,16,12,4};

        //System.out.println(t4.duplicate(arrays));

        /*int[] arrays2=new int[] {2,53,87,32};
        System.out.println(t4.findSecondNum(arrays2));*/

        //t4.RemovedulNum(arrays);

        //t4.RemovedulNum(arrays);
        //t4.findBigSmall(arrays2);
        t4.HuiWenTest2();
    }


    //判断 一串数字 是否为回文数
    public void HuiWenTest2() {
        Scanner sc=new Scanner(System.in);
        int num;
        int count=0;
        System.out.println("请输入一个整数");

        num=sc.nextInt();

        String str1=num+"";

        StringBuffer sb=new StringBuffer(str1);
        sb.reverse();
        for(int i=0;i<str1.length();i++) {
            if(str1.charAt(i)==sb.charAt(i)) {
                count++;
            }
        }

        if(count==str1.length()) {
            System.out.println(str1+"是回文数");

        }else {
            System.out.println(str1+"不是回文数");
        }


    }



    //判断 字符串 是否 为 回文串
    public void HuiWenTest() {
        String str="";
        System.out.println("请输入一个字符串");
        Scanner input=new Scanner(System.in);
        str=input.next();

        StringBuffer sb=new StringBuffer(str);

        int count=0;

        sb.reverse();

        for(int i=0;i<sb.length();i++) {
            if(str.charAt(i)==sb.charAt(i)) {
                count++;
            }
        }
        if(count==str.length()) {
            System.out.println("str字符串是回文串");
        }else {
            System.out.println("str字符串不是回文串");
        }
    }

    //如何找出最大和最小的数字在一个数组中
    public void findBigSmall(int[] arrays2) {
        int max=arrays2[0],min=arrays2[0];
        for(int i=0;i<arrays2.length;i++) {
            if(arrays2[i]>max) {
                max=arrays2[i];
            }

            if(arrays2[i]<min) {
                min=arrays2[i];
            }
        }
        System.out.println("最大值是："+max+"最小值是："+min);
    }



    // 用Java实现如何从一个数组中移除重复的元素？
    public void RemovedulNum(int[] arrays) {
        int num=0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<arrays.length;i++) {
            list.add(arrays[i]);
            //list.add(i);
        }
        Set<Integer> set = new HashSet<Integer>();
        set.addAll(list);
        System.out.println(set);


    }

    //找出数组中第二大的数
    public int findSecondNum(int[] arrays) {
        int sec_Num=-3237;
        int max=arrays[0];
        for(int i=0;i<arrays.length;i++) {
            if(arrays[i]>max) {
                sec_Num=max;
                max=arrays[i];
            }else {
                if(arrays[i]>sec_Num) {
                    sec_Num=arrays[i];
                }
            }
        }



        return sec_Num;
    }


    /**
     * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者。
     *
     * @param
     * @return
     */
    public int duplicate(int[] arrays) {

        //判断数组是否为空
        if(arrays==null || arrays.length<1) {
            System.out.println("数组 有误 ！！！");
        }

        //判断输入的数据是否在 [0,number.length-1]之间
        for(int i=0;i<arrays.length;i++) {
            if(i<0 || i>=arrays.length) {
                System.out.println("输入的数据不在 0-(n-1)范围内");
            }
        }

        //当 下标于对应的数字不相符的时候 就一直交换
        for(int i=0;i<arrays.length;i++) {
            //当 i 于 arrarys[i] 不相符 时 就一直交换
            while(arrays[i]!=i) {
                // 如果 arrays[i]=i 说明 下标与数字相符，说明有重复数字
                // 如果i位置与number[i]位置的数字相同，说明有重复数字
                if(arrays[i]==arrays[arrays[i]]) {
                    return arrays[i];
                    //如果不同就交换
                }else {

                    swap(arrays,i,arrays[i]);
                }
            }
        }
        return -1;
    }


    public void swap(int[] data,int m,int n){

        int temp;
        temp=data[m];
        data[m]=data[n];
        data[n]=temp;
    }







}
