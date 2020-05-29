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
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(220);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.goods.get();//获得数据
        }
    }
}
