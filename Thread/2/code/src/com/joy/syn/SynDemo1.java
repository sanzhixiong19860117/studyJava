package com.joy.syn;

public class SynDemo1 implements Runnable {
    private int ticker = 5;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticker > 0) {
                    System.out.println(Thread.currentThread().getName()+"还剩" + (ticker--) + "张");
                }
            }
        }
    }

    public static void main(String[] args) {
        SynDemo1 synDemo1 = new SynDemo1();
        Thread thread = new Thread(synDemo1,"a");
        Thread thread1 = new Thread(synDemo1,"b");
        Thread thread2 = new Thread(synDemo1,"c");
        Thread thread3 = new Thread(synDemo1,"d");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
