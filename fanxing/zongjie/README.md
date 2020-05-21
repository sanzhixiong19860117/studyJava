# 集合的总结

核心接口

Collection接口

常用方法：

- size()
- isEmpty()
- add()
- remove()
- clear()
- equals()

List继承于Collection接口的，所以List也有这些常用的方法。

## List的常用子类-ArrayList

1.ArrayList

ArrayList的构造函数，以及存储方式。

```java
/**
 * Constructs an empty list with an initial capacity of ten.
 */
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```

```java
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};//是一个初始化的一个常量数组
```

```java
transient Object[] elementData;//他是一个对象数组
```

数组的特点：查询快，添加删除比较慢。

2.他的扩展容量是1.5倍

```java
private int newCapacity(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
  	//扩容的核心部分
    int newCapacity = oldCapacity + (oldCapacity >> 1);
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

3.查看增加和删除的操作

增加操作

```java
public boolean add(E e) {
    modCount++;
    add(e, elementData, size);
    return true;
}
```

```java
private void add(E e, Object[] elementData, int s) {
    if (s == elementData.length)
        elementData = grow();//这里的grow函数如下
    elementData[s] = e;
    size = s + 1;
}
```

```java
private Object[] grow() {
    return grow(size + 1);
}
```

```java
//每一次增加都会向后扩容1.5倍的容量
private Object[] grow(int minCapacity) {
    return elementData = Arrays.copyOf(elementData,             newCapacity(minCapacity));
}
```

删除操作

```java
public E remove(int index) {
    Objects.checkIndex(index, size);
    final Object[] es = elementData;

    @SuppressWarnings("unchecked") E oldValue = (E) es[index];
    fastRemove(es, index);
    return oldValue;
}
```

```java
private void fastRemove(Object[] es, int i) {
    modCount++;
    final int newSize;
    if ((newSize = size - 1) > i)
      //s1原数据，移动以后的新数组，最后把对应的数组元素设置为null
        System.arraycopy(es, i + 1, es, i, newSize - i);
    es[size = newSize] = null;
}
```

## List的常用子类-LinkedList

1.构造函数进入发现没有任何的初始化操作

```java
/**
 * Constructs an empty list.
 */
public LinkedList() {
}
```

2.添加

```java
public boolean add(E e) {
    linkLast(e);
    return true;
}
```

```java
void linkLast(E e) {
    final Node<E> l = last;
  	//创建了节点
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}
```

由此可见，我门的linkedList他的底层是以链表进行存储，这种方式的好处是，添加删除效率比较高，但是查询效率比ArrayList要低。

## Vector数组

1.构造函数

```java
public Vector(int initialCapacity, int capacityIncrement) {
    super();
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    this.elementData = new Object[initialCapacity];
    this.capacityIncrement = capacityIncrement;
}
```

从这里可以看出来，Vector他的底层实现也是数组，肯定也存在扩容的问题

2.扩容2倍

```java
private int newCapacity(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                     capacityIncrement : oldCapacity);
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

3.Vector和ArrayList的具体区别。

1.arrayList是线程不安全的，Vector是线程安全的。

2.扩容行的大小不一样。

相同点：都是使用数组进行底层的实现。

## Set的子类-HashSet

1.构造函数

```java
public HashSet() {
    map = new HashMap<>();
}
```

他是用的Hashmap进行的存储，也就是使用哈希表进行存储。

2.TreeSet

```java
public TreeSet() {
    this(new TreeMap<>());
}
```

采用的是红黑树的方式进行整个的数据的操作。

注：TreeSet 加入数据的时候必须要是一种类型，不然内部排序会出现错误。

## 迭代器

java Iterator 这里通过实例

所有的集合都可以使用这个方法来进行操作

```java
package com.joy;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1111");
        list.add(true);

        //迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        Vector vector = new Vector();
        vector.add("11111111");
        vector.add(true);
        Iterator iterator1 = vector.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        List list1 = new LinkedList();
        list1.add("222222");
        list1.add(true);
        Iterator iterator2 = list1.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
//
        Set set = new HashSet();
        set.add("3333333");
        set.add(true);
        Iterator iterator3 = set.iterator();
        while(iterator3.hasNext()){
            System.out.println(iterator3.next());
        }
        Set set1 = new TreeSet();
        set1.add("44444444");
        set1.add("44444");

        Iterator iterator4= set1.iterator();
        while(iterator4.hasNext()){
            System.out.println(iterator4.next());
        }
    }
}
```

Iterator和ListIterator区别：

1.Iterator可用来遍历Set和List集合,但是ListIterator只能用来遍历List。

2.Iterator对集合只能是前向遍历,ListIterator既可以前向也可以后向。

3.ListIterator实现了Iterator接口,并包含其他的功能,比如:增加元素,替换元素,获取前一个和后一个元素的索引,等等。当有动作的操作时候是安全的。

## TreeSet排序的实现接口

1.内部排序使用的是你要排序的类进行继承接口Comparable接口实现排序重写comparTo方法。

2.外部实现使用测试类进行继承Compartor接口，重写compar方法进行排序操作。