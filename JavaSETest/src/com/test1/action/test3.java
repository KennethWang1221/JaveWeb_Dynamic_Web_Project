package com.test1.action;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        test3 t3=new test3();
        //t3.practice3();
        //t3.practice5();

        /*System.out.println(t3.divisionGCD(10,12));
        System.out.println(t3.getLCM(10,12));*/
        //t3.findMaxMin();

        int[] arrays=new int[] {
                1, 2, 3, 4, 5, 6,  8, 9, 10,
                11, 12, 13, 14, 15, 16,17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64,65, 66, 67, 68, 69, 70,
                71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                91, 92, 93, 94, 95, 96,97, 98, 99, 100};



        int[] arrays1=new int[] {
                1, 2, 3, 4, 5, 6, 7,56, 8, 9, 10,
                11, 12, 13, 14, 15, 16,17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64,65, 66, 67, 68, 69, 70,
                71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                91, 92, 93, 94, 95, 96,97, 98, 99, 100};
        //System.out.println(t3.finLostNum(arrays));
        System.out.println(t3.findDoubleNum(arrays1));

    }

	/* 解决方案二：求数组的和sum再减去0到99，剩下的
	 * 接下来，我们用一个比较巧合的做法，我们回来看题目： 现有0到99，共计100个数字，并且还有一个重复数据，这个数据也是在0到99之间 思路：
	 * A:我们把整个数组的所有元素的值给累加起来，是不是就是0到99和那个重复元素一起的和？
	 * B:我们拿这个结果减去0-99的和，那么最终结果就是那个重复的元素
	 *
	 * 方式二的弊端是：如果计算的数据特别多，就会有数据溢出，所以不好！ 更好的方式是：用异或解决！！！！！！
     * */
    //一个包含1-100数字的数组中，有一个数字重复了，如何快速的找出它？
    public int findDoubleNum(int[] arrays) {
        int num=0;
        int sum=0;
        int othersum=0;
        for(int i=0;i<100;i++) {
            sum=sum+(i+1);
        }

        for(int i=0;i<arrays.length;i++) {
            othersum=othersum+arrays[i];
        }

        num=othersum-sum;
        return num;
    }

    //一个包含1-100数字的数组中，有一个数字丢失了，如何快速的找出它
    public int finLostNum(int[] arrays) {

            int n = arrays.length;
            int sum = 0;

            for(int i=0;i<100;i++) {
                sum=sum+(i+1);
            }

            int otherSum = 0;
            for (int i=0;i<arrays.length;i++) {
                otherSum =otherSum+arrays[i];
            }

            return sum-otherSum;

    }

    //找出 数组中的最大值 最小值
    public void findMaxMin() {
        int[] array=new int[] {2,54,23,21,53,98,3};
        int min=array[0];
        int max=array[0];
        for(int i=0;i<array.length;i++) {
            if(max<array[i]) {
                max=array[i];
            }
            if (min>array[i]) {
                min=array[i];
            }
        }
        System.out.println("最大值是 "+max+" 最小值是 "+min);
    }


    //求最大公约数
    public int  divisionGCD(int m,int n) {
        /*
        * 辗转相除求最大公约数
         * 有两整数a和b：
         * ① a%b得余数c
         * ② 若c=0，则b即为两数的最大公约数
         * ③ 若c≠0，则a=b，b=c，再回去执行①
        * */
        int temp;
        while(n!=0) {
            temp=m%n;
            m=n;
            n=temp;
        }
        return m;
    }

    //求最小公倍数
    public int getLCM(int m,int n) {
        int mn=m*n;

        int result=mn/divisionGCD(m, n);

        return result;
    }





    //求1-100之间的所有素数
    public void practice5() {
        boolean flag;
        int m=0;
        for(int i=2;i<=100;i++) {
            flag=false;
            for(int j=2;j<=Math.sqrt(i);j++) {
                if(i%j==0) {
                    flag=true;
                    break;
                }
            }

            if (flag==false) {
                System.out.print(i+" ");
                m++;
            }

            if(m%10==0) {
                System.out.println("");
            }
        }

    }







    //输入一个大于3的整数n ，判定它是否为素数（prime ，又称质数）
    public void practice4() {
        /*
        * 采用的算法是，让 n 被 i 除（i 的值从2变到n-1），如果n 能被2~（n-1）
        * 之中任何一个整数整除，则表示n 肯定不是素数，不必在继续被后面的整数除，
        * 因此可以提前结束循环。注意，此时i 的值必然小于n
        * */
        Scanner sc=new Scanner(System.in);
        int i,n;
        System.out.println("请输入一个大于3的整数：");
        n=sc.nextInt();
        double k=Math.sqrt(n);
        for(i=2;i<=k;i++) {
            if(n%i==0) {

                break;
            }
        }
        if(i<=k){
            System.out.println(n+"不是素数！");
        }else {
            System.out.println(n+" 是素数");
        }
    }






    // * 6、计算1+1/4+1/9+....+1/(20*20)
    public void practice3() {
        int sum=1;
        for(int i=1;i<3;i++) {
            sum=sum+(1/(i*i));
        }
        System.out.println(" "+sum);
    }


    //4、计算1+2+3+……+100的结果。
    public void practice2() {
        int sum=1;
        for(int i=1;i<4;i++) {
            sum=sum*(i+1);

        }
        System.out.println(" "+sum);
    }


    //3、循环输出1到2000中所有能4整除但不能被100整除的数，或能被400整除的数。
    public void practice1() {
        for(int i=1;i<=2000;i++) {
            if((i%4==0 && i%100!=0) || i%400==0) {
                System.out.print(" "+i);
            }
        }
    }



     //1、循环输出1到100之间所有能被3或能被4整除的数。
    public void practice() {
        for(int i=1;i<=100;i++) {
            if(i%3==0 || i%4==0) {
                System.out.println(" "+i);
            }else {
                continue;
            }
        }
    }

    //实现一个算法，确定 一个字符串的所有自符是否全部不同。
    public boolean isUniqueChars2(String str) {
        if(str.length()>256){
            return false;
        }

        boolean[] char_set = new boolean[256];
        for(int i=0;i<str.length();i++) {
            int val=str.charAt(i);
            if(char_set[val]) {
                return false;
            }
            char_set[val]=true;
        }
        return true;
    }


}
