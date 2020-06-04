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
