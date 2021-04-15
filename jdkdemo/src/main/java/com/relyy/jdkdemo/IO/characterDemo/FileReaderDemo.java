package com.relyy.jdkdemo.IO.characterDemo;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/9/27
 */
public class FileReaderDemo {

    public static void main(String[] args) {
        String filePath = "E:\\文件\\压测环境信息.txt";
        try{
            FileReader reader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(reader);
            MyBufferReadLine myBufferReadLine = new MyBufferReadLine(br);
            String s = "";
            while ((s = myBufferReadLine.readLineWithLineNum()) != null){
                System.out.println(s);
            }
            //会导致每一行的首字符丢失
//            while (br.read() != -1){
//                System.out.println(br.readLine());
//            }
            //会导致每隔一行就会丢失
//            while (br.readLine() != null){
//                System.out.println(br.readLine());
//            }
            br.close();
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
