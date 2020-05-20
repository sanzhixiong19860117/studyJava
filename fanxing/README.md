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

- 泛型类
- 泛型接口
- 泛型方法
- 上下限（工作中用的不多，后面慢慢领悟）

1.泛型类

语法

```java
package com.joy;

/**
 * @author joy
 * @date 2020/5/20
 */
public class FanxingDemo1<b> {
}
```

其实b是一个站位符号，可以是任何的字母，数字不行， 总结起来就是标识符都符合这个占位符。

```java
package com.joy;
/**
 * @author joy
 * @date 2020/5/20
 */
public class FanxingDemo1<_b111> {
    private int id;
    private _b111 b;//这里是从类型泛型中使用的对应类型

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public _b111 getB() {
        return b;
    }

    public void setB(_b111 b) {
        this.b = b;
    }

    public void show(){
        System.out.println("id = " + this.id + "_b111="+this.b);
    }
}
```

我们使用测试类来看看其中关键看b的部分

```java
FanxingDemo1<String> fx = new FanxingDemo1<String>();
fx.setId(1);
fx.setB("sanzhixiong");
fx.show();

FanxingDemo1<Integer> fx1 = new FanxingDemo1<>();
fx1.setId(2);
fx1.setB(2);
fx1.show();
```

我们看到了在setB部分我们使用的两个不同的类型也可以正常的使用。后面需要来一个对象的类型，首先创建一个person的对象.

```java
package com.joy;

/**
 * @author joy
 * @date 2020/5/20
 */
public class Person {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
```

然后进行测试类的操作

```java
FanxingDemo1<Person> fx2 = new FanxingDemo1<>();
fx2.setId(3);
fx2.setB(new Person(1));
fx2.show();
```

```
id = 1_b111=sanzhixiong
id = 2_b111=2
id = 3_b111=Person{id=1}
```

运行显示结果为上面，证明我们先前说的，泛型只是一个占位符，它帮助我们选择自己希望的类型。

2.泛型接口

首先定义泛型接口

```java
package com.joy;

/**
 * @author joy
 * @date 2020/5/20
 */
public interface Ifanxing<b> {
    public void setFanxi(b _b);
}
```

然后定义泛型的继承接口的操作

```java
package com.joy;

/**
 * @author joy
 * @date 2020/5/20
 */
public class IFanxingEx implements Ifanxing{
    @Override
    public void setFanxi(Object _b) {
        System.out.println(_b);
    }
}
```

测试

```java
IFanxingEx f1 = new IFanxingEx();
f1.setFanxi(1);
```

然后我们可以看到这种和我们第一种很类似了。

```java
package com.joy;

/**
 * @author joy
 * @date 2020/5/20
 */
public class IFanxingEx implements Ifanxing<String>{
    @Override
    public void setFanxi(String _b) {
        System.out.println(_b);
    }
}
```

这是第二种实现，子类给接口一个类型，然后接口对应的数据类型就变成了自己定义的对应的类型。本质上还是和第一个泛型类差不多。

3.泛型方法

语法

```java
//泛型方法
public <Q> void setQ(Q q){
    System.out.println(q);
}
```

说明：第一个<Q>是定义这个方法叫做泛型方法，函数里的参数代表这个函数的参数是泛型。

测试

```java
FanxingDemo1<Integer> fx1 = new FanxingDemo1<>();
fx1.setId(2);
fx1.setB(2);
fx1.setQ("111111");//这个为泛型的方法
fx1.show();
```

