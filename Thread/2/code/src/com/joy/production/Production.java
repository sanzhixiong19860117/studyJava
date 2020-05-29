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
            System.out.println("生产了产品："+this.goods.getName()+"--"+"产品类型"+this.goods.getType());
        }
    }
}
