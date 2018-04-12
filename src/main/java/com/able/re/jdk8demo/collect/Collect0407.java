package com.able.re.jdk8demo.collect;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by relyy on 2018/4/7.
 */
public class Collect0407 {
    public static void main(String[] args) {
        Integer[] num = new Integer[]{1,2,3,4,5,6,7,8};
       // long count = Arrays.stream(num).count();
        long count = Arrays.stream(num).collect(Collectors.counting());
        System.out.println(count);
        Optional<Integer> collect = Arrays.stream(num).collect(Collectors.maxBy(Integer::compareTo));
        Integer integer = collect.get();
        System.out.println(integer);
        Integer reduce = Arrays.stream(num).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        IntSummaryStatistics collect2 = Arrays.stream(num).map(Integer::intValue).collect(Collectors.summarizingInt(a -> a * 2));

        String s = collect2.toString();
        System.out.println(s);
        String collect1 = Arrays.stream(num).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect1);

        Map<String, List<Integer>> collect3 = Arrays.stream(num).collect(Collectors.groupingBy(a -> {
            if (a % 2 == 0) {
                return "odd";
            } else {
                return "even";
            }
        }));

        collect3.get("odd").stream().forEach(System.out::print);
        System.out.println();
        collect3.get("even").stream().forEach(System.out::print);
    }
}
