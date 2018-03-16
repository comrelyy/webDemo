package com.able.re.Demo;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-12
 */
public class SetDemo {



    public static void main(String[] args) {
       //String s = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,146,155,188";

//        String s = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400";

        //String s = "#";
        String s = "0";
        //String s = "0,0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19,,";
//        String[] strArr = s.split(",");
//        if (strArr.length == 1){
//            System.out.println(strArr[0]);
//            return;
//        }


        long time1 = System.currentTimeMillis();
//        TreeSet<Integer> strSet = new TreeSet<>();
//        long l1 = System.currentTimeMillis();
//        for (String s1 : strArr) {
//
//            if (StringUtils.isNotEmpty(s1)) {
//                strSet.add(Integer.parseInt(s1));
//            }
//        }
//        long l2 = System.currentTimeMillis();
//        System.out.println("去重加转化：【"+(l2 - l1)+"】");
        //strSet.addAll(Arrays.asList(strArr));
       // strSet.addAll();
//        for (String s1 : strArr) {
//            strSet.add(s1);
//        }

        //System.out.println(strSet.toString());
        String s1 = timeCover2Simple(s);
        long time2 = System.currentTimeMillis();
        System.out.println("a转b=====【"+(time2 - time1)+"】");
        System.out.println(s1);
        //String simple = "0-400";
        String s2 = restoreTimeCover(s1);
        long time3 = System.currentTimeMillis();
        System.out.println(s2);
        System.out.println("b转a=====【"+(time3 - time2)+"】");
    }
    
    public static String timeCover2Simple(Set<Integer> strSet){
        List<Integer> list = new ArrayList<>();
        list.addAll(strSet);
        int size = strSet.size();
        StringBuffer sb = new StringBuffer();
        int before = list.get(0);
        for (int i = 0; i < size-1; i++) {
            int num1 = list.get(i);
            int num2 = list.get(i+1);

            if (!(num1+1 == num2)){
                if (num1 != before) {
                    sb.append(before).append("-").append(num1).append(",");
                }else {
                    sb.append(num1).append(",");
                }
                before = num2;
            }

            if(i+1 == size-1){
                if (num2 != before) {
                    sb.append(before).append("-").append(num2).append(",");
                }else {
                    sb.append(num2).append(",");
                }
            }
        }
        return sb.toString();
    }

    public static String restoreTimeCover(String str){
        StringBuffer sb = new StringBuffer();
        String[] timeslot =str.split(",");
        int length = timeslot.length;
        if (length <= 1){
            return str;
        }
        for (int i = 0; i < length; i++) {
            String[] times = timeslot[i].split("-");
            if (times.length == 1){
                sb.append(times[0]).append(",");
            }else {
                int first = Integer.parseInt(times[0]);
                int last = Integer.parseInt(times[1]);
                for (int j = first; j <= last; j++) {
                    sb.append(j).append(",");
                }
            }
        }
        return sb.toString();
    }

    public static Set<String> restoreTimeCoverSet(String str){
        Set<String> timeCoverSet = new TreeSet<>();
        String[] timeslot =str.split(",");
        for (int i = 0; i < timeslot.length; i++) {
            String[] times = timeslot[i].split("-");
            if (times.length == 1){
                timeCoverSet.add(times[0]);
            }else {
                int first = Integer.parseInt(times[0]);
                int last = Integer.parseInt(times[1]);
                for (int j = first; j <= last; j++) {
                    timeCoverSet.add(String.valueOf(j));
                }
            }
        }
        return timeCoverSet;
    }

    public static String timeCover2Simple(String timecover){
        String[] strArr = timecover.split(",");
        if (strArr.length == 1){
            return strArr[0];
        }

        //去重和排序
        TreeSet<Integer> strSet = new TreeSet<Integer>();
        for (String s1 : strArr) {
            if (StringUtils.isNotEmpty(s1)) {
                strSet.add(Integer.parseInt(s1));
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        list.addAll(strSet);
        int size = strSet.size();
        StringBuffer sb = new StringBuffer();
        int before = list.get(0);
        for (int i = 0; i < size-1; i++) {
            int num1 = list.get(i);
            int num2 = list.get(i+1);

            if (!(num1+1 == num2)){
                if (num1 != before) {
                    sb.append(before).append("-").append(num1).append(",");
                }else {
                    sb.append(num1).append(",");
                }
                before = num2;
            }

            if(i+1 == size-1){
                if (num2 != before) {
                    sb.append(before).append("-").append(num2).append(",");
                }else {
                    sb.append(num2).append(",");
                }
            }
        }
        return sb.toString();
    }

}
