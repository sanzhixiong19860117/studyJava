package com.joy;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);//打印是主机名+ip地址
            InetAddress byName = InetAddress.getByName("adeMacBook-Pro-2.local");//根据主机名，可以获得你的ip地址
            System.out.println(byName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
