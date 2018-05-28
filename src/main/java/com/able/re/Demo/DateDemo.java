package com.able.re.Demo;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateDemo {
    public static void main(String[] args){
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
//        Date today = new Date();
//       // Date beforeWeek =  DateUtils.addMonths(today,3);
//        System.out.println(sf.format(today));
//        //System.out.println(sf.format(beforeWeek));

//        int putIndex = 6;
//        int takeIndex = 6;

//        System.out.println(putIndex++ == takeIndex);
//        System.out.println(putIndex);
        try{
            String endTime = "2018-05-24 23:30:00";
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date();
            System.out.println(date.compareTo(form.parse(endTime)) > 0);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
