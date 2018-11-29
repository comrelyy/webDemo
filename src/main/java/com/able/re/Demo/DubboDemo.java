package com.able.re.Demo;

import java.math.BigDecimal;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/28
 */
public class DubboDemo {

    public static void main(String[] args) {
        String s = calculatePercent(43, 43, 8, 8);
        double v = Double.parseDouble(s);
        System.out.println(s);
        System.out.println(v);
        System.out.println(v < 100);

    }

    public static String calculatePercent(Integer seevideonum, Integer videototal, Integer doworknum, Integer worktotal) {
        String percent = "0";
        int num = seevideonum + doworknum;
        int total = videototal + worktotal;
        if (total > 0 && num > 0) {
            BigDecimal numDecimal = new BigDecimal(num);
            BigDecimal totalDecimal = new BigDecimal(total);
            BigDecimal percentDecimal = numDecimal.divide(totalDecimal, BigDecimal.ROUND_HALF_UP, 3);
            percent = percentDecimal.toString();
        }
        return percent;
    }
}
