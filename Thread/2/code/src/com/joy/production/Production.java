package com.joy.production;

/**
 * 生产者
 */
public class Production implements Runnable {
    //共享的是一个对象
    private Goods goods;

    public Production(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                this.goods.set("哇哈哈", "矿泉水");
            } else {
                this.goods.set("空调", "格力");
            }
        }
    }
}
