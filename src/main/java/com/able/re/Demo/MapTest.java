package com.able.re.Demo;

import com.able.re.clone.ChildVo;
import com.able.re.clone.VoDemo;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
//        Map<Long,String> iconMap = new LinkedHashMap<Long, String>();
//        iconMap.put(106537L,"http://image.zhihuishu.com/zhs/ablecommons/cutimage/201707/1d8d7e568d5c4752b024b18cf9d76245.jpg");
//        iconMap.put(122927L,"http://image.zhihuishu.com/testzhs/ablecommons/cutimage/201605/7cb16de960964d9a9184460c686d4515.jpg");
//        iconMap.put(106812L,null);
//        iconMap.put(159218746L,"http://image.zhihuishu.com/user/file/106812/ddeb9d0325dc47bea33c0fa56fe41a80.jpg");
//        iconMap.put(166998499L,"http://image.zhihuishu.com/user/file/122927/5d93538eb94f4073a470dd3a4c6cc666.jpg");
//
//        Set<Map.Entry<Long,String>> entrySet = iconMap.entrySet();
//        for (Map.Entry<Long,String> entry : entrySet) {
//            System.out.println(entry.getKey()+"======"+entry.getValue());
//        }
//        Map<String,VoDemo> testMap = new HashMap<String,VoDemo>();
//        VoDemo vo = new VoDemo();
//        vo.setAge(1);
//        vo.setId(2);
//        vo.setName("tset");
//        vo.setPhoneNum("12976688");
//        testMap.put("test",vo);
//        //ChildVo child = (ChildVo) testMap.get("test");
//        VoDemo vo2 = testMap.get("test");
//        ChildVo child = new ChildVo();
//        vo2.getClass().cast(child);
//        System.out.println(child.getName());

        final Map<String,Object> mapTest = new HashMap<String,Object>();
//        test(mapTest);
//        Set<String> strings = mapTest.keySet();
//        ArrayList<String> arrayList = new ArrayList<String>(strings);
//        for (String string : arrayList) {
//            if (mapTest.containsKey("1213")){
//                mapTest.remove(string);
//                System.out.println("通过了");
//            }
//        }

        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(mapTest);
        for (int i = 0; i <100 ; i++) {
            mapTest.put(String.valueOf(i),i);
        }

        System.out.println(mapTest);

    }

    public static void test(Map<String,Object> map){
        map.put("1213","test");
        map.put("1214","demo");
        map.put("1215",3314);
    }
}
