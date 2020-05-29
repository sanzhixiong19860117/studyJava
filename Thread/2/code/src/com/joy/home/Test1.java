package com.joy.home;

public class Test1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "==" + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Thread t = new Thread(test1);
        t.start();

        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            try {
                Thread.sleep(1501);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
