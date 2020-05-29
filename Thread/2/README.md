## 线程的生命周期

1. 新生状态（没有执行start方法之前，仅仅在new了）
2. 就绪状态（当对象的线程创建完成，并且启动star方法以后，所有的线程都放入到队列，随时抢占cpu的资源）
3. 运行状态（当前进程，获取到cpu资源以后，就是进行cpu抢占成功以后，在运行逻辑的时候）
4. 死亡状态（执行完，或者异常的时候出现的状态）
5. 阻塞状态（在程序运行过程中，发生了一些异常的情况下不能正常进行，如果异常情况得到解决，然后又恢复到就绪状态）

## 进入阻塞状态

- sleep方法
- 等待io资源

## 进入死亡状态

- 正常的结束
- 强制结束
- 出现异常情况下出现死亡情况

## 上机题：定义一个线程A，输入1-10，定一个线程B逆序输出1-10之间的整数，要求线程a和线程b交替执行

```java
package com.joy.home;

public class Test1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "==" + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Thread t = new Thread(test1);
        t.start();

        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            try {
                Thread.sleep(1501);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

## 线程同步的关键字：（其实本质就是加锁）synchronized(对象)

买票的问题解决

```java
package com.joy.syn;
public class SynDemo1 implements Runnable {
    private int ticker = 5;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticker > 0) {
                    System.out.println("还剩" + (ticker--) + "张");
                }
            }
        }
    }

    public static void main(String[] args) {
        SynDemo1 synDemo1 = new SynDemo1();
        Thread thread = new Thread(synDemo1,"a");
        Thread thread1 = new Thread(synDemo1,"b");
        Thread thread2 = new Thread(synDemo1,"c");
        Thread thread3 = new Thread(synDemo1,"d");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
```

## 同步方法：在函数中加入关键字synchronized就是同步方法。

带入如下

```java
package com.joy.syn;
public class SynMedTest implements Runnable {
    private int ticker = 5;
    @Override
    public void run() {
        update();
    }

    //同步方法
    private synchronized void update() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (ticker > 0) {
                    System.out.println(Thread.currentThread().getName() + "还剩" + (ticker--) + "张");
                }
            }
        }
    }

    public static void main(String[] args) {
        SynMedTest synMedTest = new SynMedTest();
        Thread thread = new Thread(synMedTest,"a");
        Thread thread1 = new Thread(synMedTest,"b");
        Thread thread2 = new Thread(synMedTest,"c");
        Thread thread3 = new Thread(synMedTest,"d");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
```

上面的解决的问题就数据安全问题。

## 生产消费者模式

设计思路就是生产者不停的生产产品，消费者不停的提取对应的产品。

设计思路

1. 先设计一个产品的类
2. 在设计一个生产者的类，实现线程接口，然后不停的生产
3. 消费者刚好相反

第一个版本

设计产品类

```java
package com.joy.production;

/**
 * 物品
 */
public class Goods {
    private String name;
    private String type;


    public Goods() {
    }

    /**
     * @param name 产品名字
     * @param type 产品的类型
     */
    public Goods(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
```

2.设计一个消费者的类，它是实现线程的接口

```java
package com.joy.production;

/**
 * 生产者
 */
public class Production implements Runnable{
    //共享的是一个对象
    private Goods goods;

    public Production(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i%2 == 0){
                this.goods.setName("哇哈哈");
                this.goods.setType("矿泉水");
            }
            else{
                this.goods.setName("空调");
                this.goods.setType("格力");
            }
            System.out.println("生产了产品"+this.goods.getName()+"产品类型"+this.goods.getType());
        }
    }
}
```

3.设计一个消费者的类，用来看消费者是否获得了生产的物品

```java
package com.joy.production;

/**
 * 消费者
 */
public class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者收到" + this.goods.getName() + "品牌" + this.goods.getType());
        }
    }
}
```

4.写一个测试类

```java
package com.joy.production;

public class Test {
    public static void main(String[] args) {

        Goods goods = new Goods();
        //创建生产者
        Production production = new Production(goods);
        //消费者
        Consumer consumer = new Consumer(goods);

        Thread t1 = new Thread(production);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
```

出现了一些不同步的情况，比如先消费了，后才有生产者，根据之前的经验，我是使用同步方法来看，在Goods设计两个同步方法

```java
//第一种方案使用同步方法
public synchronized void set(String name,String type){
    this.setName(name);
    this.setType(type);
    System.out.println("生产了产品："+this.getName()+"--"+"产品类型:"+this.getType());
}

public synchronized void get(){
    System.out.println("消费者收到：" + this.getName() + "----品牌:" + this.getType());
}
```

发现还是会出现不同步的问题，于是在加了一个标示位，通过标示为判断是否应该去生产，应该去消费了。

核心如下

Goods类增加一个标示

```java
//默认为falst 就是需要生产
private boolean flog = false;
```

后面的方法需要修改一些细节

```java
//第一种方案使用同步方法
public synchronized void set(String name,String type){
    //判断是否应该生产
    if(flog){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    this.setName(name);
    this.setType(type);
    System.out.println("生产了产品："+this.getName()+"--"+"产品类型:"+this.getType());

    //如果生产完毕需要重制相关的状态和数值
    flog = true;
    notify();//释放当当前wait()状态
}

public synchronized void get(){
    if(!flog){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println("消费者收到：" + this.getName() + "----品牌:" + this.getType());
    //重制对应信息
    flog = false;
    notify();//释放当当前所wait()状态
}
```

这样生产消费者就没有问题了。

下面是用队列进行数据的添加和获取操作来测试

生产者：

```java
package com.joy.production1;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 */
public class ProductionQueue implements Runnable {
    private BlockingQueue blockingQueue;

    public ProductionQueue(BlockingQueue blockingQueue) {
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
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                this.blockingQueue.put(i);
                System.out.println("生产者生产:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

消费者

```java
package com.joy.production1;

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
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
                System.out.println("消费者进行消费：" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

测试类

```java
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
```

其中ArrayBlockingQueue 是一个泛型，可以放入自定的类在里面进行测试。

一个生产对应多个消费者可以进行一个测试。