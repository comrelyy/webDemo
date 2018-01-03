package com.able.re.Demo;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicLong;

public class TestInteger {
    public static void main(String[] args){

        //List<String> list = new ArrayList<String>();
//        TestNull test = new TestNull();
//        test.setId(128);
//        if(test.getId() == (DemoConstants.TEST_INTEGER)){
//            System.out.println(System.currentTimeMillis());
//        }else {
//            System.out.println(test.getId());
//        }


//        Integer a = new Integer(13);
//        int b = 13;
//
//
//        System.out.println(a==b);
//

//
//        String a = "abc";
//        String b = "ab";
//        String c = b + "c";
//
//
//        System.out.println(a == c);

        Integer videoTime =  423;
        Integer totalWatchTime = 422;

        DecimalFormat df =new DecimalFormat("0.00000");
        String percentStr = df.format((float)totalWatchTime/videoTime).substring(0,4);
        double watchPercent = Double.valueOf(percentStr) * 100;

        AtomicLong count = new AtomicLong();
        count.incrementAndGet();
        System.out.println(watchPercent);

    }
}
