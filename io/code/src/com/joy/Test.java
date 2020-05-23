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
