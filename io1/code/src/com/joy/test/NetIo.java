package com.joy.test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class NetIo {
    public static void main(String[] args) {
        //首先数输入流和输出流的编写
        InputStreamReader inputStreamReader = null;                 //输入流
        OutputStreamWriter outputStreamWriter = null;               //输出
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            inputStreamReader = new InputStreamReader(new URL("http://www.baidu.com").openStream(), "utf-8");
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream("baidu.html"));

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String msg = null;
            while ((msg = bufferedReader.readLine()) != null) {
                bufferedWriter.write(msg);//写入数据
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
