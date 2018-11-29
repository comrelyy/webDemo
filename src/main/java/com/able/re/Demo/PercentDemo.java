package com.able.re.Demo;

import org.springframework.beans.BeanUtils;

import java.text.DecimalFormat;

public class PercentDemo {

    public static void main(String[] args){
        Integer videoTime = 968;
        Integer watchTime = 30;


        System.out.println(watchTime/videoTime);
        DecimalFormat df =new DecimalFormat("0.00");


        String percentStr = df.format((float)watchTime/videoTime);
        System.out.println(percentStr);
        double watchPercent = Double.valueOf(percentStr) * 100;
        System.out.println(watchPercent);
        System.out.println(watchPercent > 100 ? true : false);
    }
}
