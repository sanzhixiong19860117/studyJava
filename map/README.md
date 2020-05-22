# Map接口学习

1.为什么要使用k-v的进行操作

因为k-v可以更快的进行搜索，并且k-v是一一对应的操作，查询效率高。

2.map接口常用的几个类是那些

- HashMap
- LinkedMap
- TreeMap

3.数据结构层面上查看

- HashMap使用哈希表进行操作（1.7以前使用的是数组和链表的形式，1.8以后，数组+链表+红黑树的形式操作）
- LinedMap使用的是链表的形式进行存储（查询时间比较快）
- TreeMap使用的是红黑树的方式进行存储

4.基础操作

```java
package com.joy;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        //基础api的基础使用
        Map<Integer,String> map = new HashMap<Integer, String>();
        //加入操作
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        System.out.println("删除前"+map);
        //查找
        System.out.println(map.containsKey(1));             //根据key来查询
        System.out.println(map.containsValue("wangwu"));    //这是根据value来查询
        //删除
//        map.clear();  全部清空
//        map.remove(2);指定删除
        //获取
        System.out.println("获得="+map.get(1));
        System.out.println("删除后"+map);
        //判断是否为空
        System.out.println("是否为空"+map.isEmpty());
        //获得长度
        System.out.println("map长度="+map.size());
        //循环操作
        //第一种采用集合的操作
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //获得对应的key数值
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        //获得value
        Collection<String> values = map.values();
        for (String s:values){
            System.out.println(s);
        }
    }
}
```

HashMap和HashTabel的区别

- HashMap线程不安全，效率比较高，HashTabel线程安全，效率低。
- HashMap key-value 可以为null，但是HashTabel不允许为null

初始化容器数量

```java
/**
 * The default initial capacity - MUST be a power of two.
 */
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
```

扩容系数

```java
/**
 * The load factor used when none specified in constructor.
 */
static final float DEFAULT_LOAD_FACTOR = 0.75；
```

这个是插入某一个数量以后就需要扩容了比如16*0.75=12 这个时候到了12就需要进行扩容的操作了。

1.8以后的源码分析请查看

https://blog.csdn.net/tuke_tuke/article/details/51588156

1.7可以查看

[http://www.wachsbeere.com/2019/02/28/Java%E9%9B%86%E5%90%88%E6%BA%90%E7%A0%81%EF%BC%9AHashMap%EF%BC%88JDK%201.7%EF%BC%89/](http://www.wachsbeere.com/2019/02/28/Java集合源码：HashMap（JDK 1.7）/)