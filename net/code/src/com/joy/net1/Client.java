package com.joy.net1;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端操作
         Socket socket = new Socket("localhost",10000);
         //发送数据
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //发送
        dataOutputStream.write("你好服务器".getBytes());
        //接受
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] buf = new byte[1024];
        int read = dataInputStream.read(buf);
        System.out.println(new String(buf,0,read));
        //关闭
        outputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
        inputStream.close();
        socket.close();
    }
}
