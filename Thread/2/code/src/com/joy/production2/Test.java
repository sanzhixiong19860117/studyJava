package com.joy.production2;

import com.joy.production1.ProductionQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(30); //5是个数
        BreadProductionQeue breadProductionQeue = new BreadProductionQeue(blockingQueue);
        NoodleProdQueue noodleProdQueue = new NoodleProdQueue(blockingQueue);
        YoghurtProdQueue yoghurtProdQueue = new YoghurtProdQueue(blockingQueue);
        ConsumerQueue consumerQueue = new ConsumerQueue(blockingQueue);
        new Thread(breadProductionQeue).start();
        new Thread(noodleProdQueue).start();
        new Thread(yoghurtProdQueue).start();
        new Thread(consumerQueue).start();
    }
}
