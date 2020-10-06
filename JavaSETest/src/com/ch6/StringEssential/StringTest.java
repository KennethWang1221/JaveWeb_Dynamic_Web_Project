package com.ch6.StringEssential;

public class StringTest {
    public static void main(String[] args) {
        String s="abcdeqwert";
        System.out.println("字符串的长度 ："+s.length());
        System.out.println("字符串的长度 ："+s.charAt(0));
        System.out.println("字符串的长度 ："+s.indexOf('c'));
        System.out.println("字符串的长度 ："+s.lastIndexOf('c'));

        String s2="old string";
        System.out.println("将 old 替换成 new 的结果 ："+s2.replace("old","new"));
        String s3=" o l d S t r i n g";
        System.out.println("去除空格"+s3.trim());
        System.out.println(s3.replace(" ",""));

        String s4="String";
        String s5="str";

        System.out.println("判断是否以字符串str开头："+s4.startsWith("str"));
        System.out.println("判断是否以字符串ng结尾："+s4.endsWith("ng"));
        System.out.println("判断是否包含字符串："+s4.contains("tri"));
        System.out.println("判断是否包含字符串："+s4.equals(s5));


        String s6="abcs";
        System.out.println("将字符串转换为字符数组后的结果：");
        char[] charArray=s6.toCharArray();
        for(int i=0;i<charArray.length;i++) {
            if(i!=charArray.length-1) {
                System.out.print(charArray[i]+",");
            }else {
                System.out.println(charArray[i]);
            }

        }

        System.out.println("将int 值转换为String类型之后的结果："+s6.valueOf(12));
        System.out.println("将字符串转换成大写之后的结果："+s6.toUpperCase());


        String s7="羽毛球-篮球-乒乓球";
        System.out.println("从第五个字符截取到末尾的结果："+s7.substring(4));
        System.out.println("从第五个字符截取到末尾的结果："+s7.substring(4,6));
        System.out.println("分割后的字符串数组中的元素依次为：");
        String[] strArray=s7.split("-");
        for(int i=0;i<strArray.length;i++) {
            if(i!=strArray.length-1) {
                System.out.print(strArray[i]+",");
            }
            else{
                System.out.println(strArray[i]);
            }
        }





    }
}
