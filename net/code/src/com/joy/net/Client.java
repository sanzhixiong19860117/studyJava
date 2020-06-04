package com.joy.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 10086);
        //发送数据
        OutputStream outputStream = client.getOutputStream();
        //封装
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("hello,你好");

        dataOutputStream.close();
        outputStream.close();
        client.close();
    }
}
