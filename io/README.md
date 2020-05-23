# io学习

## 基础应用file

创建file对象

```java
File file = new File("1111.txt");
```

这里是创建一个1111.txt在，相当于一个手把一个文件放入对应的文件夹中

## 基础之OutPutStream

输出流

```java
package com.joy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class Test {
    public static void main(String[] args) {
        //file基础使用
        File file = new File("./111.txt");
        OutputStream outputStream = null;
        try {
          //输入流的操作
            outputStream = new FileOutputStream(file);
            outputStream.write("sanzhixiong".getBytes());
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
```



## 基础之FileInputStream

读取操作

```java
package com.joy;
import java.io.*;
public class Test {
    public static void main(String[] args) {
        InputStream inputStream = null;
        File file = null;
        try
        {
            file = new File("111.txt");
            try{
              //这里是核心
                inputStream = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.println(new String(bytes,0,len));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                inputStream.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
```

## FileReader 读取的方法

```java
Reader reader = null;
try{
    reader = new FileReader("111.txt");
  //一个是字符数组，一个是二进制数组
    char[] chars = new char[1024];
    int len = 0;
    while((len = reader.read(chars)) != -1){
        System.out.println(new String(chars,0,len));
    }
}catch (Exception e){
    e.printStackTrace();
}
finally {
    try{
        reader.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
}
```

FileReader和FileInputStream的比较

- 一个读取的是字符数组，一个是byte数组
- 对于中文的支持，字符数组要强于byte数组