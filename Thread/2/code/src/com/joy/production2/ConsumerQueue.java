package com.joy.production2;

import com.joy.production2.vo.Bread;
import com.joy.production2.vo.Noodle;
import com.joy.production2.vo.Yoghurt;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class ConsumerQueue implements Runnable {

    private BlockingQueue blockingQueue;

    public ConsumerQueue(BlockingQueue blockingQueue) {
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
        for (int i = 0; i < 100; i++) {
            try {
                Object object = blockingQueue.take();
                Thread.sleep(50);
                if(object instanceof Bread){
                    Bread bread = (Bread)object;
                    System.out.println("消费：" + bread.getName()+"----"+bread.getPrice());
                }else if(object instanceof Noodle){
                    Noodle noodle = (Noodle)object;
                    System.out.println("消费：" + noodle.getName()+"===="+noodle.getPrice());
                }else{
                    Yoghurt yoghurt = (Yoghurt)object;
                    System.out.println("消费：" + yoghurt.getName()+"-=-="+yoghurt.getPrice());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
