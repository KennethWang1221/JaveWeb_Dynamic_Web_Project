package com.test1.action;

public class test2 {
    /*public static void main(String[] args) {
        //使用 冒泡排序 + 二分查找 法
        int[] arr={2,65,23,1,98,34,51,4};

        test2 t2=new test2();

        System.out.println("排序前 打印 数组：");
        t2.printArray(arr);


        t2.BubbleSort(arr);

        System.out.println("排序后 打印 数组：");
        t2.printArray(arr);

        System.out.println("\n");

        //使用二分查找法查找指定数字
        int myNum=65;
        int start=0;
        int end=arr.length-1;

        while(true) {

            int middle=(start+end)/2;

            if(myNum>arr[middle]) {
                start=middle+1;
            }else if(myNum<arr[middle]){
                end=middle-1;
            }else{
                System.out.println("指定数字："+myNum+"排在第"+(middle+1)+"位");
                break;
            }

            if(start>end) {
                System.out.println("查无此数");
                break;
            }
        }


    }

    private void BubbleSort(int[] arr) {

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++) {
                int temp;
                if(arr[j]>arr[j+1]) {
                    *//*temp=arr[j];
                    arr[j+1]=temp;
                    arr[j]=arr[j+1];*//*
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第"+i+"轮排序结果为");
            printArray(arr);
        }
        System.out.print("\n");
    }

    //定义一个打印数组的方法
    public void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }*/


















}
