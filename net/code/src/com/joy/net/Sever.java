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
