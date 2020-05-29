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

## 上机题：定义一个线程A，输入1-10，定一个一个线程B逆序输出1-10之间的整数，要求线程a和线程b交替执行

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

