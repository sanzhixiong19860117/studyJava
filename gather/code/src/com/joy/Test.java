package com.joy;

import java.util.*;

/**
 * @author joy
 * @version 1.0
 * @date 2020/5/7 15:12
 * 集合的测试类
 */
public class Test {
    public static void main(String[] args) {
//        //list接口的基础使用
//        List list = new ArrayList();
//        //基础的增加
//        list.add("sanzhixiong");
//        list.add(23);
//        list.add("男");
//        System.out.println(list);
//        //删除
//        list.remove(0);
//        System.out.println(list);
//        //改
//        list.set(0, "sanzhixiong");
//        System.out.println(list);
//        //查
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        //查的另一种方式iterator的对象方式
//        final Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        //list接口的基础使用
        List list = new ArrayList();
        list.add("java1");
        list.add("java2");
        list.add("java3");
        //遍历
        final ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
            if (obj.equals("java2")) {
                iterator.remove();
            }
        }
    }
}
