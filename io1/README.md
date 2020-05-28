# 系统的输入输出流

- System.in
- System.out

System.in 他是继承于 InputStream，所以他也是一个流的操作，叫做标准输入

System.out 它也是OutputStream的一个子类，标准输出流。

作用：可以来自键盘的输入和输出。

## 题目1:接受来自一个键盘的输入，并且输出出来

```java
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
```

## 题目2:读取URL的网络返回字符串

```java
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
          //URL的类的使用
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
```

这个例子和前面的例子的区别就在于URL的类的基础使用。