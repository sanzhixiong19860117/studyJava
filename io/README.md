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

FileWriter 写入数据

```java
File file = new File("222.txt");
Writer writer = null;
try{
    writer = new FileWriter(file);
    writer.write("三只熊你是谁");
    writer.write("我就是我啊");
  	writer.flush();
}catch (Exception e){
    e.printStackTrace();
}finally {
    try{
        writer.close();
    }catch (Exception e){
        e.printStackTrace();
    }
}
```

去掉close方法会有问题，有可能数据没有写入到对应的文件下面，然后使用 writer.flush();防止数据没有写入。

凡事在写入的时候一定要记得使用一个flush()方法让数据进入到缓冲区。

## 字节流和字符流的作用

- 字节流可以用于所有的读写操作（音频，视频，文本）
- 如果是文本的话，还是使用字符流比较好一点

下面是对这个说法的举例程序复制图片

```java
//复制图片之字符数组操作
FileReader fileReader = null;
FileWriter fileWriter = null;
try{
    fileReader = new FileReader("1.jpg");
    fileWriter = new FileWriter("2.jpg");
    int len = 0;
    char[] chars = new char[1024];
    while((len = fileReader.read(chars))!=-1){
        fileWriter.write(chars);
    }
}
catch (Exception e){
    e.printStackTrace();
}finally {
    try
    {
        fileReader.close();
        fileWriter.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
}
```

这个时候我们看到的图片是不能打开的，因为文件是毁坏的。

下面这种

```java
FileInputStream fileReader = null;
FileOutputStream fileWriter = null;
try{
    fileReader = new FileInputStream("1.jpg");
    fileWriter = new FileOutputStream("2.jpg");
    int len = 0;
    byte[] chars = new byte[1024];
    while((len = fileReader.read(chars))!=-1){
        fileWriter.write(chars);
    }
}
catch (Exception e){
    e.printStackTrace();
}finally {
    try
    {
        fileReader.close();
        fileWriter.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }
}
```

复制出来的图片就是可用的。