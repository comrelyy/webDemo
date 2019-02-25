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
            String endTime = "2019-02-17 16:50:00";
            String endTime1 = "2019-02-18 17:20:00";
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            Date start = form.parse(endTime);
            Date end = form.parse(endTime1);
            long time1 = (end.getTime() -start.getTime())/60;
            long time2 = (end.getTime() -date.getTime())/60;
            System.out.println((end.getTime() -start.getTime())/60);
            System.out.println((end.getTime() - date.getTime())/60);
            Integer limitTime = 50;
            long time = time2 > time1 ? time1 : time2;
            Integer timeInter = Integer.valueOf(time/1000 + "");
            int compare = Integer.compare(timeInter, limitTime);
            if (compare < 0){
                System.out.println(timeInter);
            }else {
                System.out.println(limitTime);
            }
//            System.out.println(form.parse(endTime1).before(date));
//            Date dNow = new Date(); //当前时间
//            //Date dBefore = new Date();
//
//            Calendar calendar = Calendar.getInstance(); //得到日历
//            calendar.setTime(dNow);//把当前时间赋给日历
//            calendar.add(Calendar.DAY_OF_MONTH, -1); //设置为前一天
//            Date dBefore = calendar.getTime(); //得到前一天的时间
//
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
//            String defaultStartDate = sdf.format(dBefore); //格式化前一天
//            defaultStartDate = defaultStartDate+" 00:00:00";
//            String defaultEndDate = defaultStartDate.substring(0,10)+" 23:59:59";
//            System.out.println("前一天的起始时间是：" + defaultStartDate);
//            System.out.println("前一天的结束时间是：" + defaultEndDate);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
