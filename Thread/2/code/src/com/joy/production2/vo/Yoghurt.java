package com.joy.production2.vo;

public class Yoghurt {
    private String name;
    private float price;//价格

    public Yoghurt() {
    }

    public Yoghurt(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
