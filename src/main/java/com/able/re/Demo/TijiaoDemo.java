package com.able.re.Demo;

import java.net.URL;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/21
 */
public class TijiaoDemo {

    public static void main(String[] args) throws Exception{
        String[] urls = {
                "http://121.43.40.135:20010/onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=7806&examId=509657&userId=188733237",
                "http://121.43.40.135:20010/onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=7683&examId=490850&userId=190225925",
                "http://121.43.40.135:20010/onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=7683&examId=490851&userId=190225925",

        };
        for (String urlstr : urls) {
            URL url = new URL(urlstr);
            url.openStream();
        }

    }
}
