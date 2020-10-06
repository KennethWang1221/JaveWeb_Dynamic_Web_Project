package com.ch6.StringTest1;

import java.util.Random;
import java.util.Scanner;

public class GassGame {
    public static void main(String[] args) {
        String ts=null;
        String[] tss=null;
        char[] da =new char[4];
        String[] das=new String[4];

        ts="白日依山尽，黄河入海流，欲穷千里目，更上一层楼";
        tss=ts.split("，");

        //扣字
        Random random=new Random();
        for(int i=0;i<tss.length;i++) {
            int n=random.nextInt(5);
            da[i] = tss[i].charAt(n);
        }

        //换成？
        for(int i=0;i<4;i++) {
            tss[i] = tss[i].replace(da[i], '?');
        }

        for(int i=0;i<4;i++) {
            System.out.println(tss[i]);
        }

        //准备答案
        int rightIndex= random.nextInt(4);
        das[rightIndex]=""+da[0]+da[1]+da[2]+da[3];

        Tools t=new Tools();
        for(int i=0;i<das.length;i++) {
            if(i==rightIndex) {
                continue;
            }
            t.c(da);
            das[i]=""+da[0]+da[1]+da[2]+da[3];
        }

        for(int i=0;i<4;i++) {
            System.out.println((i+1)+" 、"+das[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择正确答案");
        int index =scanner.nextInt();
        if((rightIndex+1)==index) {
            System.out.println("答对了，牛逼");
        }else {
            System.out.println("请你在想想！");
        }



    }
}
