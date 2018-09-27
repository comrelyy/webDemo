package com.able.re.IO.bytesDemo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/9/27
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        String filePath = "E:\\文件\\压测环境信息.txt";
        FileInputStream in = null;
        try{
            in = new FileInputStream(filePath);
//            int size = in.available();
//            byte[] bytes = new byte[size];
//            String a = new String(bytes);
//            System.out.println(a);
//            in.read(bytes);
//            String s = new String(bytes);
//            System.out.println(s);

//            BufferedInputStream bi = new BufferedInputStream(in);
//            byte[] bytes = new byte[1024];
//            while (bi.read(bytes,0,1024) != -1) {
//                System.out.println(new String(bytes));
//            }
                //字节流转字符流
            InputStreamReader reader = new InputStreamReader(in,"UTF-8");
            char[] chars = new char[1024];
            while (reader.read(chars) != -1) {
                System.out.println(new String(chars));
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
