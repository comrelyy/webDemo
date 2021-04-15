package com.relyy.jdkdemo.Demo;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

public class PercentDemo {

    public static void main(String[] args){
//        Integer videoTime = 968;
//        Integer watchTime = 30;
//
//
//        System.out.println(watchTime/videoTime);
//        DecimalFormat df =new DecimalFormat("0.00");
//
//
//        String percentStr = df.format((float)watchTime/videoTime);
//        System.out.println(percentStr);
//        double watchPercent = Double.valueOf(percentStr) * 100;
//        System.out.println(watchPercent);
//        System.out.println(watchPercent > 100 ? true : false);
        Double scoreDouble = 5.5;
        BigDecimal scoreBigDecimal = new BigDecimal(scoreDouble);
        Double score = scoreBigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(subZeroAndDot(String.format("%.2f", score)));

        System.out.println(getMaxAnswerScore("5.5", "5.5", null));
        System.out.println(getRoundScore("5.5"));
    }

    /**
     *
     * @Description 去掉小数多余的0
     * @author xuliquan
     * @date 2015年11月18日 下午3:01:51
     * @param
     * @return
     */
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    public static String getMaxAnswerScore(String dbScore, String cacheScore, String stuExamScore) {
        Double dbDoubleScore = StringUtils.isEmpty(dbScore) ? 0 : Double.valueOf(dbScore);
        Double cacheDoubleScore = StringUtils.isEmpty(cacheScore) ? 0 : Double.valueOf(cacheScore);
        Double stuExamDoubleScore = StringUtils.isEmpty(stuExamScore) ? 0 : Double.valueOf(stuExamScore);
        double max = Math.max(Math.max(dbDoubleScore, cacheDoubleScore), stuExamDoubleScore);
        return max+"";
    }

    public static String getRoundScore(String score) {
        if (StringUtils.isNotEmpty(score)) {
            long round = Math.round(Double.valueOf(score));
            //保留一位小数
            BigDecimal scoreBigDecimal = new BigDecimal(round);
            Double scoreDouble = scoreBigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            return score = subZeroAndDot(String.format("%.2f", scoreDouble));
        }
        return null;
    }
}
