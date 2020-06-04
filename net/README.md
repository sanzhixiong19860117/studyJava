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
          //根据主机名，可以获得你的ip地址
            InetAddress byName = InetAddress.getByName("adeMacBook-Pro-2.local");
            System.out.println(byName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

Tcp：三次握手

点名->答应->确认（重点）

## TCP编程

socket（插座）

快速编程

客户端向服务器发送消息

```java
package com.joy.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhsot", 10086);
        //发送数据
        OutputStream outputStream = client.getOutputStream();
        //封装
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("hello");
        dataOutputStream.close();
        outputStream.close();
        client.close();
    }
}
```

服务器操作

```java
package com.joy.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        //返回客户端的socket
        Socket client = serverSocket.accept();
        //获得相关的数据
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        //读取对应的数据
        String str = dataInputStream.readUTF();
        System.out.println(str);
        dataInputStream.close();
        inputStream.close();
        client.close();
        serverSocket.close();
    }
}
```

先启动服务器

## UDP编程