package com.joy;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //基础api的基础使用
        Map<Integer,String> map = new HashMap<Integer, String>();
        //加入操作
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        System.out.println("删除前"+map);
        //查找
        System.out.println(map.containsKey(1));             //根据key来查询
        System.out.println(map.containsValue("wangwu"));    //这是根据value来查询
        //删除
//        map.clear();  全部清空
//        map.remove(2);指定删除
        //获取
        System.out.println("获得="+map.get(1));
        System.out.println("删除后"+map);
        //判断是否为空
        System.out.println("是否为空"+map.isEmpty());
        //获得长度
        System.out.println("map长度="+map.size());
        //循环操作
        //第一种采用集合的操作
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //获得对应的key数值
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        //获得value
        Collection<String> values = map.values();
        for (String s:values){
            System.out.println(s);
        }
    }
}
