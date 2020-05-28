package com.joy.demo;

public class TickerDemo1 extends Thread{

    private int ticker = 5;
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            if(ticker>0){
                System.out.println("还剩"+(ticker--)+"张");
            }
        }
    }

    public static void main(String[] args) {
        //使用thred方式
        System.out.println("hello");
        TickerDemo1 t1 = new TickerDemo1();
        TickerDemo1 t2 = new TickerDemo1();
        TickerDemo1 t3 = new TickerDemo1();
        TickerDemo1 t4 = new TickerDemo1();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
