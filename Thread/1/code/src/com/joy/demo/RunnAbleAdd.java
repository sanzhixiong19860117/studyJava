package com.joy.demo;

public class RunnAbleAdd implements Runnable {
    private int sum = 0;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum =" + sum);
    }

    public static void main(String[] args) {
        RunnAbleAdd runnAbleAdd = new RunnAbleAdd();
        Thread thread = new Thread(runnAbleAdd);
        thread.start();
    }
}
