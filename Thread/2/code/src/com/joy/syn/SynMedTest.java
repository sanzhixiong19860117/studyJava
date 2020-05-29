package com.joy.syn;

public class SynMedTest implements Runnable {

    private int ticker = 5;

    @Override
    public void run() {
        update();
    }

    //同步方法
    private synchronized void update() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticker > 0) {
                    System.out.println(Thread.currentThread().getName() + "还剩" + (ticker--) + "张");
                }
            }
        }
    }

    public static void main(String[] args) {
        SynMedTest synMedTest = new SynMedTest();
        Thread thread = new Thread(synMedTest,"a");
        Thread thread1 = new Thread(synMedTest,"b");
        Thread thread2 = new Thread(synMedTest,"c");
        Thread thread3 = new Thread(synMedTest,"d");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
