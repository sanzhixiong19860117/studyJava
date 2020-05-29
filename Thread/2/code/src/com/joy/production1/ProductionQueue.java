package com.joy.production1;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 */
public class ProductionQueue implements Runnable {
    private BlockingQueue blockingQueue;

    public ProductionQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public BlockingQueue getBlockingQueue() {
        return blockingQueue;
    }

    public void setBlockingQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                this.blockingQueue.put(i);
                System.out.println("生产者生产:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
