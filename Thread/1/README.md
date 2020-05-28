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

## 第二种方法实现Runnable实现方式

```java
package com.joy.demo;

public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
```

基础点：

1. 使用Runnable接口进行继承
2. 同样重写run的方法
3. 创建继承Runnable的类
4. 创建Thread来装入Runnable子对象，然后在进行star方法开启线程。

推荐使用第二种方式

## 买票操作

使用thread来实现

```java
package com.joy.demo;
public class TickerDemo1 extends Thread{
    private int ticker = 5;
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            if(ticker>0){
                System.out.println("还剩"+(ticker--)+"张");
            }
        }
    }

    public static void main(String[] args) {
        //使用thred方式
        System.out.println("hello");
        TickerDemo1 t1 = new TickerDemo1();
        TickerDemo1 t2 = new TickerDemo1();
        TickerDemo1 t3 = new TickerDemo1();
        TickerDemo1 t4 = new TickerDemo1();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
```

共享数据错乱

```java
package com.joy.demo;

public class RunnableTicker implements Runnable {
    private int ticker = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(ticker>0){
                System.out.println("还剩"+(ticker--)+"张");
            }
        }
    }

    public static void main(String[] args) {
        RunnableTicker r1 = new RunnableTicker();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r1);
        Thread t5 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
```

使用Runnable接口实现可以少创建很多的对象，但是还是会有数据问题。

