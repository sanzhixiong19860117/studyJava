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
