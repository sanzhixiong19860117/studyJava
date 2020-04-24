package com.joy.packages;

/**
 * @author joy
 * @version 1.0
 * @date 2020/4/24 20:03
 */

/**
 * String 基础api使用
 * 1.使用String str初始化以后使用 == 创建是一样的字符串就是两个地址是一样
 * 2.
 */
public class StrinApi {
    public static void main(String[] args) {
        String s1 = "helloworld";
        String s2 = "helloworld   ";
        String s3 = new String("helloworld");
        String s4 = new String("helloworld").intern();
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);
        /**
         * equals 核心操作
         * if (this == anObject) {
         *     return true;
         * }
         * if (anObject instanceof String) {
         *     tring aString = (String)anObject;
         *        if (coder() == aString.coder()) {
         *           return isLatin1() ? StringLatin1.equals(value, aString.value)
         *                   : StringUTF16.equals(value, aString.value);
         *      }
         *  }
         *  equals 都是使用字符串数组进行对比一个一个的比较，如果没有就返回出错
         */
        System.out.println(s1.equals(s3));//是判断两个字符串是否字符相同
        System.out.println(s1 == s4);

        //常用的方法CharAt
        System.out.println(s1.charAt(0));
        //核心 (char)(value[index] & 0xff);
        //取低八位的数据
        char[] value = {'h', 'e'};
        System.out.println((char) (value[0] & 0xff));
        //indexof查询字符串的位置
        //如果让我实现，就是直接循环查找，返回找到的第一个字符的下标
        System.out.println(s1.indexOf("h"));
        //如果让我实现，就是把所有的字符串变成小写，然后在使用equals方法进行操作
        System.out.println(s1.equalsIgnoreCase("helloworld"));
        //数组的长度
        System.out.println(s1.length());
        //是否开始为h字符串是为true
        System.out.println(s1.startsWith("h"));
        //结束是否以d技术是为true
        System.out.println(s1.endsWith("d"));
        //截取substring 如果只有一个参数就说明从当前的开始直到最后一个结束，如果有两个参数
        //就会有对应的两个中间的操作
        System.out.println(s1.substring(0));

        System.out.println(s2.trim());
    }
}
