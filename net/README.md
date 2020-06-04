# 网络学习基础

## 基本概念

一组计算机连接组成

1. 交换数据
2. 共享资源

网络三要素

1. ip
2. 端口
3. 通信协议

## 网络分层

osi的网络模型

tcp/ip参考模型

应用层，表示层，会话层=》应用层

传输层=〉传输层

网络层=》网络层

数据传输层，物理层=》网络接口层

ip地址的使用

InetAddress类

基础使用

```java
package com.joy;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);//打印是主机名+ip地址
            InetAddress byName = InetAddress.getByName("adeMacBook-Pro-2.local");//根据主机名，可以获得你的ip地址
            System.out.println(byName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

## 数据封装拆分

## 网络爬虫原理

## tcp编程

## UDP编程