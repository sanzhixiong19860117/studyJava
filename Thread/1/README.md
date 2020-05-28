## 线程的概念

程序：一个指令的集合。

进程：正在执行中的程序。

线程：轻量级的进程

资源：进程是申请资源的最小单位，线程和进程共同享受这部分大小。

为什么需要多线程：因为需要多个程序同时执行操作。

```java
package com.joy.demo;
public class ThreadDemo1 extends Thread{
    //重写run方法
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();

        for (int i = 0; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
```

基础：

1. 首先继承Thread 这个类
2. 要重写run这个方法
3. 关键：就是要使用star（）方法启动线程的操作

