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
