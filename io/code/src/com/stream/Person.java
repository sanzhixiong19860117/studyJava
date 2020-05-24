package com.stream;

import java.io.Serializable;

/**
 * @author joy
 * @date 2020/5/24
 */
public class Person implements Serializable {
    private int id;
    private transient String name;//隐藏这个数据操作

    public int getId() {
        return id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
