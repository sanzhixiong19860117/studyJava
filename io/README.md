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



## 基础之InputStream

读取操作

