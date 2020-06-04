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

第二步创建服务器也可以回话的消息

```java
package com.joy.net1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器已经启动");
        //创建服务器的socket
        ServerSocket serverSocket = new ServerSocket(10000);
        //获得客户端的具柄
        Socket socket = serverSocket.accept();
        //接受数据
        InputStream inputStream = socket.getInputStream();

        //包装
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] buf = new byte[1024];
        int read = dataInputStream.read(buf);
        System.out.println(new String(buf,0,read));
        //发送数据
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.write("你好客户端".getBytes());
        //关闭
        inputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
```

客户端

```java
package com.joy.net1;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端操作
         Socket socket = new Socket("127.0.0.1",10000);
         //发送数据
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //发送
        dataOutputStream.write("你好服务器".getBytes());
        //接受
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] buf = new byte[1024];
        int read = dataInputStream.read();
        System.out.println(new String(buf,0,read));
        //关闭
        outputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
        inputStream.close();
        socket.close();
    }
}
```

## UDP编程