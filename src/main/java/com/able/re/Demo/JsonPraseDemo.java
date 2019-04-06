package com.able.re.Demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/2/26
 */
public class JsonPraseDemo {

    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        String string = JSONObject.toJSONString(linkedList);
//        System.out.println(string);
//        List<Integer> parseArray = JSONArray.parseArray(string, Integer.class);
//        System.out.println(parseArray);

        List<Map<String, Integer>> maps = new ArrayList<Map<String, Integer>>();
        Map<String, Integer> map = new HashMap<>();
        map.put("courseId",12334);
        map.put("recruitId",12334);
        map.put("schoolId",12334);
        maps.add(map);
        String string = JSONObject.toJSONString(maps);
        System.out.println(string);
        List<Map> maps1 = JSONArray.parseArray(string, Map.class);
        System.out.println(maps1);

    }
}
