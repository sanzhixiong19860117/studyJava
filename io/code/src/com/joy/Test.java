package com.joy;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        //file基础使用
        File file = new File("./111.txt");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            String str = "sanzhixiong";//写入对应的数据
            outputStream = new FileOutputStream(file);
            outputStream.write(str.getBytes());
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = 0;
            String msg = null;
            while ((len = inputStream.read(bytes)) != -1) {
                msg = new String(bytes,0,len);
            }
            System.out.println("读取相对应的数据来"+msg);
            inputStream.close();
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
