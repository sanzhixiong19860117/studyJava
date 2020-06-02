# 线程池

## 线程池的好处

1. 避免线程的重复创建
2. 可以提高系统的响应速度
3. 可以动态管理系统线程池的大小

## 工作原理

1. 先判断线程池中核心线程池中所有的线程是否都在执行任务。如果不是，则新创建一个线程进行执行任务，则进入第2部；
2. 判断当前祖泽队列是否已经满了，如果未满执行把任务放到队列中，否则进入3
3. 判断线程池中所有的线程是否都在执行任务，如果没有，则创建一个新的线程来执行任务，否则，则交给饱和策略来处理

newCachedThreadPool 线程池的创建

创建一个线程对象

```java
package com.joy;

public class Task implements Runnable{
    @Override
    public void run() {
       System.out.println(Thread.currentThread().getName());
    }
}
```

创建线程池

```java
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
```

1. 线程中没有固定的线程，最大的是21亿
2. 线程中线程可以重复运用
3. 当线程池中，没有可用线程，会重复创建新的线程。

newFixedThreadPool 线程池

```java
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
```

重用我们指定的线程的个数进行线程池的操作。

newSingleThreadExecutor 创建一个线程池进行运行

```java
package com.joy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
```

## 延迟执行的线程池

ScheduledExecutorService 延迟操作

```java
package com.joy;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒钟");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
```

scheduleAtFixedRate 使用延迟线程中的这个方法，可以每一段时间执行一次

```java
package com.joy;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟一秒钟执行，每个三秒执行一次");
            }
        }, 1,3, TimeUnit.SECONDS);
    }
}
```

## 线程池的生命周期

线程池的生命周期有两个状态

1.运行状态

说明：线程可以接受到新的任务，可以及时添加任务处理。

2.shutdown状态

说明：就是线程在执行了shutdown以后，不接受新的任务，但是处理已经添加的任务。

3.stop状态

说明：不接受新任务，不处理已经添加的任务，并且会中断正在处理的任务（很黄很暴力）。

4.Tidying状态

说明：没有任何的任务都终止了，任务的队列也执行完了的时候，就会调用Terminated状态。

5.Terminated状态

说明：线程池彻底的终止。

