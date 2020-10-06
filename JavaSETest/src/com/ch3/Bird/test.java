package com.ch3.Bird;

public class test{
    //获取二维数组每列最小的值
    public static void main(String[] args){
        /**
         * 求出二维数组每列的最小值
         */

            //二维数组
            int[][] arrays = {
                    {23, 106, 8, 234},
                    {2, 9, 73, 19},
                    {56, 25, 67, 137}};

            //求得 数组 有多少列
            int maxcolLength=arrays[0].length;

            //定义一个数组 用来 存放 每一列中 最小的数值
            int[] minArrays=new int[maxcolLength];

            for(int i=0;i<arrays[0].length;i++) {
                int min=arrays[0][i];
                for(int j=0;j<arrays.length;j++) {
                    if(arrays[j][i]<min) {
                        min=arrays[j][i];
                    }
                    minArrays[i]=min;
                }
                System.out.println("第"+(i+1)+"列中最小的值是："+minArrays[i]);
            }



    }

}






