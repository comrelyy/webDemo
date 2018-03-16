package com.able.re.Demo;

import org.apache.commons.lang3.StringUtils;

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
        String a = "1440635";
//        String b = "ab";
//        String c = b + "c";
//
//
//        System.out.println(a == c);

//        Integer videoTime =  423;
//        Integer totalWatchTime = 422;
//
//        DecimalFormat df =new DecimalFormat("0.00000");
//        String percentStr = df.format((float)totalWatchTime/videoTime).substring(0,4);
//        double watchPercent = Double.valueOf(percentStr) * 100;
//
//        AtomicLong count = new AtomicLong();
//        count.incrementAndGet();
//        System.out.println(watchPercent);
        if (StringUtils.isNotEmpty(a)) {
            Double fileSize = Double.valueOf(a);
            DecimalFormat df = new DecimalFormat("#.0");
            String fileSizeKB = df.format(fileSize/1000);
            if ( Double.valueOf(fileSizeKB) >= 1000.00){
                String fileSizeM = df.format(Double.valueOf(fileSizeKB)/1000);
                System.out.println(fileSizeM+"M");
            }else {
                System.out.println(fileSizeKB+"KB");
            }
        }
    }
}
