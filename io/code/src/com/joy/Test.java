package com.joy;

import java.io.*;

public class Test {
    public static void main(String[] args) {
//        InputStream inputStream = null;
//        File file = null;
//        try
//        {
//            file = new File("111.txt");
//            try{
//                inputStream = new FileInputStream(file);
//                byte[] bytes = new byte[1024];
//                int len = 0;
//                while ((len = inputStream.read(bytes)) != -1) {
//                    System.out.println(new String(bytes,0,len));
//                }
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            try{
//                inputStream.close();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }

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
                //writer.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
