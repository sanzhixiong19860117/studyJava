package com.joy.production;

/**
 * 物品
 */
public class Goods {
    private String name;
    private String type;


    public Goods() {
    }

    /**
     * @param name 产品名字
     * @param type 产品的类型
     */
    public Goods(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
