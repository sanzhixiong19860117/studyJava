package com.joy.production2;

import com.joy.production1.ProductionQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5); //5是个数
        BreadProductionQeue breadProductionQeue = new BreadProductionQeue(blockingQueue);
        NoodleProdQueue noodleProdQueue = new NoodleProdQueue(blockingQueue);
        YoghurtProdQueue yoghurtProdQueue = new YoghurtProdQueue(blockingQueue);
        ConsumerQueue consumerQueue1 = new ConsumerQueue(blockingQueue);
        new Thread(consumerQueue1).start();
        new Thread(breadProductionQeue).start();
        new Thread(noodleProdQueue).start();
        new Thread(yoghurtProdQueue).start();

    }
}
