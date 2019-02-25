package com.able.re.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/1/29
 */
public class CompareDemo {

    public static void main(String[] args) {
        ArrayList<CompareVo> compares = new ArrayList<>();
        compares.add(new CompareVo(0, 0, 2));
        compares.add(new CompareVo(1, 0, 2));
        compares.add(new CompareVo(2, 0, 1));
        compares.add(new CompareVo(3, 1, 1));
        compares.add(new CompareVo(4, 1, 0));
        compares.add(new CompareVo(5, 1, 0));

//        Collections.sort(compares, new Comparator<CompareVo>() {
//            @Override
//            public int compare(CompareVo o1, CompareVo o2) {
//                return o1.getMeetType().compareTo(o2.getMeetType());
//            }
//        });

        Collections.sort(compares, new Comparator<CompareVo>() {
            @Override
            public int compare(CompareVo o1, CompareVo o2) {
                return o2.getRecruitIdType().compareTo(o1.getRecruitIdType());
            }
        });

        System.out.println(compares);

    }

}
