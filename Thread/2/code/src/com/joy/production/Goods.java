package com.joy.production;

/**
 * 物品
 */
public class Goods {
    private String name;
    private String type;
    //默认为falst 就是需要生产
    private boolean flog = false;

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

    //第一种方案使用同步方法
    public synchronized void set(String name,String type){
        //判断是否应该生产
        if(flog){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.setName(name);
        this.setType(type);
        System.out.println("生产了产品："+this.getName()+"--"+"产品类型:"+this.getType());

        //如果生产完毕需要重制相关的状态和数值
        flog = true;
        notify();//释放当当前所
    }

    public synchronized void get(){
        if(!flog){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者收到：" + this.getName() + "----品牌:" + this.getType());
        //重制对应信息
        flog = false;
        notify();
    }
}
