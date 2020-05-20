# 泛型

## 泛型的出现

使用list进行说明

```java
package com.joy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joy
 * @date 2020/5/20
 */
public class Test {
    public static void main(String[] args) {
        //使用list进行说明
        List list = new ArrayList();
        list.add("1");
        list.add(1);
        list.add(true);
        System.out.println(list);
    }
```

这里和我们前面学习到的list使用方法一样，然后我们使用循环进行操作。

```java
package com.joy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joy
 * @date 2020/5/20
 */
public class Test {
    public static void main(String[] args) {
        //使用list进行说明
        List list = new ArrayList();
        list.add("1");
        list.add(1);
        list.add(true);
        System.out.println(list);

        //第一种循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //第二种循环增强循环
        for(Object b:list){
            System.out.println(b);
        }
    }
}
```

其中第二个循环我们没有办法进行一个具体的类型操作，使我们的循环方式不太方便只能通过类型转换赚到自己想要的类型，这样我们引入到了泛型，泛型主要是针对我们统一类型起到一定的作用。

```java
package com.joy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joy
 * @date 2020/5/20
 */
public class Test {
    public static void main(String[] args) {
        //使用list进行说明
        List<String> list = new ArrayList();//使用泛型以后
        list.add(true);
    }
}
```

使用泛型以后我们在想list存入不是相同类型的数据就会报错，这样我们就不会出现刚才那种什么类型数据都可以插入的尴尬地步。

## 泛型的集中类型

