package com.joy.demo;

public class RunnableTicker implements Runnable {
    private int ticker = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(ticker>0){
                System.out.println("还剩"+(ticker--)+"张");
            }
        }
    }

    public static void main(String[] args) {
        RunnableTicker r1 = new RunnableTicker();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r1);
        Thread t5 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
