package com.joy.production2;

import com.joy.production2.vo.Noodle;
import com.joy.production2.vo.Yoghurt;

import java.util.concurrent.BlockingQueue;

/**
 * 面条生产者
 */
public class NoodleProdQueue implements Runnable{
    private BlockingQueue blockingQueue;

    public NoodleProdQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Noodle noodle = new Noodle("小面",5.0f);
            try {
                blockingQueue.put(noodle);
                System.out.println("生产:"+noodle.getName()+"--"+"价格:"+noodle.getPrice());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
