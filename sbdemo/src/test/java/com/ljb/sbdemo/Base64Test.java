package com.ljb.sbdemo;
import java.io.File;
import java.io.FileInputStream;
import sun.misc.BASE64Encoder;
public class Base64Test {
    public static void base64(int a){
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop\\test5.mp4");
            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            System.out.println(new BASE64Encoder().encode(buffer));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
