package com.joy.test;

import java.util.Comparator;
import java.util.TreeSet;

public class Test implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge()>o2.getAge()){
            return -1;
        }
        else if(o1.getAge()<o2.getAge()){
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Test());
        treeSet.add(new Person("zhangsan",12));
        treeSet.add(new Person("lisi",13));
        System.out.println(treeSet);
    }
}
