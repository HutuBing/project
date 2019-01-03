package com.ljb.sbdemo.test;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;

public class Base64Test {
    public static String base64(int i){
        try {
            File file;
            if (i == 0)
                file = new File("C:\\Users\\Administrator\\Desktop\\test5.mp4");
            else
                file = new File("C:\\Users\\Administrator\\Desktop\\test.jpg");
            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            return (new BASE64Encoder().encode(buffer));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
