# Java容器

## 基础与作用

list接口的作用：他是存储不唯一，有序的对象。

继承接口的三个类：ArrayList，linkdList，vector

基础使用

```java
package com.joy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joy
 * @version 1.0
 * @date 2020/5/7 15:12
 * 集合的测试类
 */
public class Test {
    public static void main(String[] args) {
        //list接口的基础使用
        List list = new ArrayList();
        //基础的增加
        list.add("sanzhixiong");
        list.add(23);
        list.add("男");
        System.out.println(list);
    }
}
```

删除

```java
list.remove(0);//删除对应的索引对象
```

改

```java
list.set(0,"sanzhixiong");//对索引下的数据进行修改
```

查的操作

```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

## list接口实现类

特点：有序，不唯一。

ArrayList的特点：实现是长度可变的数组，在内存中连续分配空间。

优点：访问元素效率比较高。

缺点：添加和删除的效率比较低。

linkedList的特点：使用链表方式来存储数据。

优点：删除和添加的效率比较高。

缺点：访问数据的效率比较低。

Vector的特点和ArrayList一样，但是两者之间也有区别：

- 在多线程的使用中，arrayList不是安全的，vector它是安全的不过效率比较低。
- 他们都是可扩容的，arraylist扩容是原来的1.5倍，vector是原来的2倍。

ArrayList扩容的核心

```java
private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
    	//>>1右移一位是/2的意思，证明增加了自己一半的大小
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
            ? newCapacity
            : hugeCapacity(minCapacity);
    }
```

Vector

```java
private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                         capacityIncrement : oldCapacity);//这里是核心的地方是2倍
        if (newCapacity - minCapacity <= 0) {
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
            ? newCapacity
            : hugeCapacity(minCapacity);
    }
```



## list的持有方法

- 添加add，addAll，addAll
- 删除remove(index)
- 改 set(index,element)
- 查 get(index),subList(form,to),iterator操作

## iterator接口

作用：所有的实现Collection解扩的容器类都有一个iterator方法，他的作用是返回一个实现了iterator接口的对象。

iterator对象他称作为迭代器。

常用的方法：

- hasNext判断元素有遍历
- next 返回游标的当前位置
- remove 删除某一个元素

基础使用

```java
//查的另一种方式iterator的对象方式
final Iterator iterator = list.iterator();
while (iterator.hasNext()) {
  System.out.println(iterator.next());
}
```

ListIterator的出现

```java
List list = new ArrayList();
list.add("java1");
list.add("java2");
list.add("java3");
//遍历
final Iterator iterator = list.iterator();
while (iterator.hasNext()) {
   Object obj = iterator.next();
   System.out.println(iterator.next());
   if (obj.equals("java2")) {
     iterator.remove();
   }
}
```

这段代码会报错，主要原因就是访问的时候进行了多次操作，有点类似于多线程的操作了。

解决方法使用 ListIterator 进行删除就不会报错

```java
//list接口的基础使用
        List list = new ArrayList();
        list.add("java1");
        list.add("java2");
        list.add("java3");
        //遍历
        final ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
            if (obj.equals("java2")) {
                iterator.remove();
            }
        }
```

使用的核心代码：

```java
public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }
```

```java
final void checkForComodification() {
            if (modCount != expectedModCount)//判断的核心
                throw new ConcurrentModificationException();
        }
```

```java
int expectedModCount = modCount;//在实现的内部类的时候是初始化一样的，如果你有删除或者添加的时候会有改变这个数值的行为所以会报错
```

