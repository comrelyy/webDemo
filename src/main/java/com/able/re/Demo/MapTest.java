package com.able.re.Demo;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        Map<Long,String> iconMap = new LinkedHashMap<Long, String>();
        iconMap.put(106537L,"http://image.zhihuishu.com/zhs/ablecommons/cutimage/201707/1d8d7e568d5c4752b024b18cf9d76245.jpg");
        iconMap.put(122927L,"http://image.zhihuishu.com/testzhs/ablecommons/cutimage/201605/7cb16de960964d9a9184460c686d4515.jpg");
        iconMap.put(106812L,null);
        iconMap.put(159218746L,"http://image.zhihuishu.com/user/file/106812/ddeb9d0325dc47bea33c0fa56fe41a80.jpg");
        iconMap.put(166998499L,"http://image.zhihuishu.com/user/file/122927/5d93538eb94f4073a470dd3a4c6cc666.jpg");

        Set<Map.Entry<Long,String>> entrySet = iconMap.entrySet();
        for (Map.Entry<Long,String> entry : entrySet) {
            System.out.println(entry.getKey()+"======"+entry.getValue());
        }
    }
}
