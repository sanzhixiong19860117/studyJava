package com.joy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_pool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            //提交
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
