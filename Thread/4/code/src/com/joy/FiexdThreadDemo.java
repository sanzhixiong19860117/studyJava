package com.joy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FiexdThreadDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20 ; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
