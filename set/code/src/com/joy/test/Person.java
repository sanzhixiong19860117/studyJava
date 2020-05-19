package com.joy.test;

public class Person implements Comparable{
    private String name;
    private int age;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //使用内部实现接口的方法
    @Override
    public int compareTo(Object o) {
        Person person = (Person)o;
        if(this.age>person.age){
            return 1;
        }else if(this.age<person.age){
            return -1;
        }else {
            return 0;
        }
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
