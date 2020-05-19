# HashSet和TreeSet

基础应用

```java
package com.joy.test;
import java.util.TreeSet;
public class Test {
    public static void main(String[] args) {
        //TreeSet基础使用
        TreeSet treeSet = new TreeSet();
        //增加
        treeSet.add("11111");
        System.out.println(treeSet);
        //查找
        System.out.println(treeSet.contains("11111"));
        //删除
        treeSet.remove("11111");
        System.out.println(treeSet);
    }
}
```

底层是使用了treeMap这种数据结构，既是采用了红黑树的数据结果进行数据的存储。

```java
public TreeSet() {
    this(new TreeMap<>());
}
```

特点：

- 优点：查询速度要比list的快
- 缺点：查询没有hashSet快

## Comparable接口

为什么要使用Comparable接口

```java
package com.joy.test;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        //TreeSet基础使用
        TreeSet treeSet = new TreeSet();
        treeSet.add("aaaaaaa");
        treeSet.add(true);
        System.out.println(treeSet);
    }
}
```

如果加入两个不同类型的数据，就会产生错误报错如下

```
Exception in thread "main" java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Boolean (java.lang.String and java.lang.Boolean are in module java.base of loader 'bootstrap')
	at java.base/java.lang.Boolean.compareTo(Boolean.java:45)
	at java.base/java.util.TreeMap.put(TreeMap.java:566)
	at java.base/java.util.TreeSet.add(TreeSet.java:255)
	at com.joy.test.Test.main(Test.java:10)
```

说明内部有一个自动排序的过程，我把true改成"aaaaa"以后在运行错误不见了。并且显示打印结果为[aaaaa, aaaaaaa] 可以看到一个从小到大的顺序排列。

问题2:如果我是一个对象的话怎么办看下面的代码

首先常见一个Person类

```java
package com.joy.test;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

测试类

```java
package com.joy.test;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("zhangsan",12));
        treeSet.add(new Person("lisi",13));
        System.out.println(treeSet);
    }
}
```

发现它报错了，当然我是勇的jdk14的操作它是报错的

```
Exception in thread "main" java.lang.ClassCastException: class com.joy.test.Person cannot be cast to class java.lang.Comparable (com.joy.test.Person is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
	at java.base/java.util.TreeMap.compare(TreeMap.java:1291)
	at java.base/java.util.TreeMap.put(TreeMap.java:536)
	at java.base/java.util.TreeSet.add(TreeSet.java:255)
	at com.joy.test.Test.main(Test.java:9)
```

Comparable接口两种方式

1. 在类自己实现这个接口叫内部实现
2. 如果在测试类中实现这个接口在外部实现

代码如下：

```java
package com.joy.test;

public class Person implements Comparable{
    private String name;
    private int age;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //使用内部实现接口的方法
    @Override
    public int compareTo(Object o) {
        Person person = (Person)o;
        if(this.age>person.age){
            return 1;
        }else if(this.age<person.age){
            return -1;
        }else {
            return 0;
        }
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

测试类

```java
package com.joy.test;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("zhangsan",12));
        treeSet.add(new Person("lisi",13));
        System.out.println(treeSet);
    }
}
```

输出结果为：[Person{name='zhangsan', age=12}, Person{name='lisi', age=13}]

这个方式是内部类实现的接口方式。

外部实现方式：

```java
package com.joy.test;

import java.util.Comparator;
import java.util.TreeSet;

public class Test implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge()>o2.getAge()){
            return -1;
        }
        else if(o1.getAge()<o2.getAge()){
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Test());
        treeSet.add(new Person("zhangsan",12));
        treeSet.add(new Person("lisi",13));
        System.out.println(treeSet);
    }

}
```

如果既有外部实现方式又有内部实现方式的话，以外部实现的接口函数为判断的依据。