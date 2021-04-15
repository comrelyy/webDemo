package com.relyy.jdkdemo.IO.characterDemo;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/9/27
 */
public class MyBufferReadLine {

    private BufferedReader reader;
    private int lineNum;

    public MyBufferReadLine(BufferedReader reader) {
        this.reader = reader;
        this.lineNum = 0;
    }

    public String readLineWithLineNum() throws IOException{
        String s = null;
        if ((s = reader.readLine()) != null){
            lineNum++;
            s = lineNum+"   "+s;
        }
        return s;
    }
}
