package com.joy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joy
 * @date 2020/5/20
 */
public class Test {
    public static void main(String[] args) {
//        //使用list进行说明
//        List<String> list = new ArrayList();
////        list.add("1");
////        list.add(1);
////        list.add(true);
////        System.out.println(list);
////
////        //第一种循环
////        for (int i = 0; i < list.size(); i++) {
////            System.out.println(list.get(i));
////        }
////
////        //第二种循环增强循环
////        for(Object b:list){
////            System.out.println(b);
////        }
        FanxingDemo1<String> fx = new FanxingDemo1<String>();
        fx.setId(1);
        fx.setB("sanzhixiong");
        fx.show();

        FanxingDemo1<Integer> fx1 = new FanxingDemo1<>();
        fx1.setId(2);
        fx1.setB(2);
        fx1.setQ("111111");
        fx1.show();

        FanxingDemo1<Person> fx2 = new FanxingDemo1<>();
        fx2.setId(3);
        fx2.setB(new Person(1));
        fx2.show();

        IFanxingEx f1 = new IFanxingEx();
        f1.setFanxi("11111");


    }
}
