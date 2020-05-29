package com.joy.production;

public class Test {
    public static void main(String[] args) {

        Goods goods = new Goods();
        //创建生产者
        Production production = new Production(goods);
        //消费者
        Consumer consumer = new Consumer(goods);

        Thread t1 = new Thread(production);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
