package com.joy.test;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        //首先数输入流和输出流的编写
        InputStreamReader inputStreamReader = null;                 //输入流
        OutputStreamWriter outputStreamWriter = null;               //输出
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        inputStreamReader = new InputStreamReader(System.in);       //标准输出和输出
        outputStreamWriter = new OutputStreamWriter(System.out);
        bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        String str = "";
        try {
            while (!str.equals("exit")) {
                str = bufferedReader.readLine();//读取一行
                bufferedWriter.newLine();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();//一定要加这个
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
