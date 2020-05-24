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
