package com.joy.packages;

/**
 * @author joy
 * @version 1.0
 * @date 2020/4/24 21:19
 */
public class HomeWork {
    public static void main(String[] args) {
        String str = "我爱你中国，我爱你故乡。";
        String keywords = "中国";
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(keywords, index)) != -1) {
            if (str.indexOf(keywords, index) != -1) {
                index = index + keywords.length();
                count++;
            }
        }
        System.out.println("次数=" + count);
    }
}
