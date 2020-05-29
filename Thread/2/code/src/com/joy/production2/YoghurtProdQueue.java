package com.joy.production2;

import com.joy.production2.vo.Yoghurt;

import java.util.concurrent.BlockingQueue;

/**
 * 酸奶生产商
 */
public class YoghurtProdQueue implements Runnable {
    private BlockingQueue blockingQueue;

    public YoghurtProdQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Yoghurt yoghurt = new Yoghurt("酸奶", 2.0f);
            try {
                blockingQueue.put(yoghurt);
                System.out.println("生产:" + yoghurt.getName() + "--" + "价格:" + yoghurt.getPrice());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
