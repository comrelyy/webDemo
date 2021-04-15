package com.relyy.jdkdemo.Demo;

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
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352018&userId=194076489",
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352019&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699131&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699132&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699135&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699138&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699157&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699177&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699181&userId=194076489",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699245&userId=194076489",

                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352018&userId=193739425",
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352019&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699131&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699132&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699135&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699138&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699157&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699177&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699181&userId=193739425",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699245&userId=193739425",

                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352018&userId=193695709",
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352019&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699131&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699132&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699135&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699138&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699157&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699177&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699181&userId=193695709",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699245&userId=193695709",

                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352018&userId=193685453",
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352019&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699131&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699132&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699135&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699138&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699157&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699177&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699181&userId=193685453",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699245&userId=193685453",

                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352018&userId=193477985",
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352019&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699131&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699132&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699135&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699138&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699157&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699177&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699181&userId=193477985",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699245&userId=193477985",

                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352018&userId=193400325",
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352019&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699131&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699132&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699135&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699138&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699157&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699177&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699181&userId=193400325",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699245&userId=193400325",

                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352018&userId=193112975",
                 "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=352019&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699131&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699132&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699135&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699138&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699157&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699177&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699181&userId=193112975",
                "http://47.96.161.181:8988//onlineQuartz/stuExamSubmitScoreQueue/getStuExamSubmitScoreQueueInfo?recruitId=12053&examId=1699245&userId=193112975",


        };
        for (String urlstr : urls) {
            URL url = new URL(urlstr);
            url.openStream();
        }

    }
}
