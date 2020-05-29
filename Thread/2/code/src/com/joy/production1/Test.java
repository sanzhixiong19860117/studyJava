package com.joy.production1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5); //5是个数
        ProductionQueue productionQueue = new ProductionQueue(blockingQueue);
        ConsumerQueue consumerQueue = new ConsumerQueue(blockingQueue);
        new Thread(productionQueue).start();
        new Thread(consumerQueue).start();
    }
}
