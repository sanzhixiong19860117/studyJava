package com.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author joy
 * @date 2020/5/24
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        //字节数组
        //ByteArrayInputStream
        //1.查看api中的对象的构造函数它有两个构造函数

        ByteArrayOutputStream arrayOutputStream = null;//输入

        String str = "sanzhixiong";
        try {
            arrayOutputStream = new ByteArrayOutputStream();
            arrayOutputStream.write(99);
            arrayOutputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                arrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //创建一个buf的byte数组
        int read = 0;
        ByteArrayInputStream byteArrayInputStream = null;
        byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        while((read = byteArrayInputStream.read())!=-1){
            System.out.print((char)read);
        }
    }
}
