package com.joy.packages;

/**
 * @author joy
 * @version 1.0
 * @date 2020/4/24 17:48
 * 包装类的基本使用
 */
public class Packaging {
    public static void main(String[] args) {
        //猜想这个说明==两边的地址是一样的
        Integer intValue = new Integer(10);
        int a = 10;
        System.out.println(intValue == a);
        //基础操作为falst的原因是因为创建了两个不同的对象导致地址不同
        Integer c = new Integer(100);
        Integer d = new Integer(100);
        Integer e = new Integer(10);
        System.out.println(c == d);
        System.out.println(a == e);//两块数据位置是一样
        //自动装箱
        /**
         * if (i >= IntegerCache.low && i <= IntegerCache.high)
         *    return IntegerCache.cache[i + (-IntegerCache.low)];
         *  在-127-126之间的时候是比较两个缓存的操作，超过了这个范围就会出现重新new就会出现
         */
        Integer i = Integer.valueOf(100);
        Integer f = Integer.valueOf(100);
        System.out.println(i == f);//为true
        Integer i1 = Integer.valueOf(200);
        Integer f1 = Integer.valueOf(200);
        System.out.println(i1 == f1);

        /**
         * Float(parseFloat(s));
         * 他是重新new的所以两个数据不想等
         */
        Float f2 = new Float(1.0);
        Float f3 = new Float(1.0);
        System.out.println(f2 == f3);
        /**
         * Double
         * new Double(d);
         * 所以两个数值肯定不一样
         */
        Double d1 = Double.valueOf(1.0);
        /**
         * Long 和integer一样超过了-127-126范围就不相等
         */
        Long l1 = Long.valueOf(10);
        //拆装操作 intValue();
        //基础操作
        int vlaue1 = new Integer(10);
        int value2 = new Integer(10).intValue();
    }
}
