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

字节流之 ByteArrayOutputStream，ByteArrayOutputStream 的基础使用

```java
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
```



BufferedOutputStream和bufferedInputStream

```java
package com.stream;

import java.io.*;

/**
 * @author joy
 * @date 2020/5/24
 */
public class BufDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("3.txt");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            inputStream = new FileInputStream(file);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream.write(1);
            bufferedOutputStream.write("sanzhixiong".getBytes());
            bufferedOutputStream.write("三只熊".getBytes());
            bufferedOutputStream.flush();

            //读取
            int read = bufferedInputStream.read();
            while((read = bufferedInputStream.read())!= -1){
                System.out.println((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            outputStream.close();
            bufferedOutputStream.close();
          	bufferedInputStream.close();
        }
    }
}
```

DataOutputStream,DataInputStream基础使用

```java
package com.stream;

import java.io.*;

/**
 * @author joy
 * @date 2020/5/24
 */
public class DataStreamDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("444.txt");
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        InputStream inputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(outputStream);
            inputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(inputStream);
            try {
                dataOutputStream.writeInt(90);
                dataOutputStream.write("三只熊".getBytes());
                dataOutputStream.writeBoolean(false);
                dataOutputStream.flush();

                int id = dataInputStream.readInt();
                int read = dataInputStream.read();
                boolean b = dataInputStream.readBoolean();
                System.out.println("id = "+id+"read="+read + "b="+b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            dataOutputStream.close();
            inputStream.close();
            dataInputStream.close();
        }
    }
}
```

注意：读取和写入顺序要一模一样（类型也要一模一样）

核心之一：ObjectOutputStream基础使用

```java
package com.stream;

import java.io.*;

/**
 * @author joy
 * @date 2020/5/24
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("555.txt");
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeInt(111);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeObject(new Person(1,"sanzhixiong"));
            objectOutputStream.flush();

            //读取
            inputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream);
            int id = objectInputStream.readInt();
            boolean b = objectInputStream.readBoolean();
            Person p = (Person)objectInputStream.readObject();
            System.out.println("id="+id+"b="+b+"paerson="+p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            outputStream.close();
            objectOutputStream.close();
            inputStream.close();
            objectInputStream.close();
        }
    }
}
```

详细的请可以查看

https://blog.csdn.net/dreamtdp/article/details/15378329

## serializable接口

它的作用只是为了标示这个类要被序列化。