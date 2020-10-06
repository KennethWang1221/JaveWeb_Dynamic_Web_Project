package com.test1.action;

import java.util.Scanner;


// *12、输入年份和月份，打印该该月份的日历，例如：输入2011年9月，就打印2011年9月的日历
//判断 是否 为 闰年 判定公历闰年应遵循的一般规律为:四年一闰，百年不闰，四百年再闰.
public class leaptyearTest {
    public static void main(String[] args) {
        leaptyearTest leapyear=new leaptyearTest();
        leapyear.leaptyearTest1();
    }

    public void leaptyearTest1() {
        int month, year;
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入年份：");
        year = sc.nextInt();

        System.out.println("请输入月份：");
        month = sc.nextInt();

        //判断输入月份的合法性
        if (month <= 12 && month >= 1) {
            /*
             * 判断大月份 小月份
             * */
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                for (int i = 1; i <= 31; i++) {
                    System.out.print(" " + i);
                    if (i % 7 == 0) {
                        System.out.println("");
                    }
                }
            } else if (month == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    for (int i = 1; i <= 29; i++) {
                        System.out.print(" " + i);
                        if (i % 7 == 0) {
                            System.out.println("");
                        }
                    }
                } else {
                    for (int i = 1; i <= 28; i++) {
                        System.out.print(" " + i);
                        if (i % 7 == 0) {
                            System.out.println("");
                        }
                    }
                }
            } else {
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    for (int i = 1; i <= 30; i++) {
                        System.out.print(" " + i);
                        if (i % 7 == 0) {
                            System.out.println("");
                        }
                    }
                }
            }
        } else {
            System.out.println("请检查输入的月份！！！");
        }
    }
}
