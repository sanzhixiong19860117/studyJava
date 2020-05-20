package com.joy;
/**
 * @author joy
 * @date 2020/5/20
 */
public class FanxingDemo1<_b111> {
    private int id;
    private _b111 b;//这里是从类型泛型中使用的对应类型

    //泛型方法
    public <Q> void setQ(Q q){
        System.out.println(q);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public _b111 getB() {
        return b;
    }

    public void setB(_b111 b) {
        this.b = b;
    }

    public void show(){
        System.out.println("id = " + this.id + "_b111="+this.b);
    }
}