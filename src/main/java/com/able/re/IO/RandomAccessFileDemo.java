package com.able.re.IO;

import java.io.RandomAccessFile;

/**
 * 文件随机读取
 * @author cairuirui
 * @create 2018/9/27
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws Exception{
        String filePath = "E:\\文件\\压测环境信息1.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"rw");
        long length = randomAccessFile.length();
        System.out.println("文件长度:"+length);
        randomAccessFile.seek(length);

        //randomAccessFile.write(345);//写入指定得字节
        randomAccessFile.writeBoolean(true);
        length = randomAccessFile.length();
        System.out.println("文件长度:"+length);
        randomAccessFile.close();
    }
}
