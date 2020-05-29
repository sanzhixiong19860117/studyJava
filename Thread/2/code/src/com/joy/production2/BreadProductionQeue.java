package com.joy.production2;

import com.joy.production2.vo.Bread;

import java.util.concurrent.BlockingQueue;

/**
 * 面包生产厂商
 */
public class BreadProductionQeue implements Runnable {
    private BlockingQueue<Bread> blockingQueue;

    public BreadProductionQeue(BlockingQueue<Bread> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        //生产面包
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bread bread = new Bread("牛奶面包",1.5f);
            try {
                blockingQueue.put(bread);
                System.out.println("生产:"+bread.getName()+"--"+"价格:"+bread.getPrice());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
