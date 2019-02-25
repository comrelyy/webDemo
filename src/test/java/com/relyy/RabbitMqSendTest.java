package com.relyy;

import com.alibaba.fastjson.JSONObject;
import com.relyy.VO.rabbitmqTestVo.AssignationMakeUpExamVo;
import com.relyy.VO.rabbitmqTestVo.StuSetExamTime;
import com.relyy.VO.rabbitmqTestVo.StudiedExamMqDto;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/30
 */
public class RabbitMqSendTest extends TestBaseService {

    @Resource
    private AmqpTemplate assignationMakeUpExamForUserAmqpTemplate;

    @Resource
    private AmqpTemplate rmqTemplate;

    @Resource
    private AmqpTemplate setTimeAmqpTemplate;
    @Resource
    private AmqpTemplate doStudentExamRecordAmqpTemplate;
    @Resource
    private AmqpTemplate asyncSubmitStudentExamAmqpTemplate;
    @Resource
    private AmqpTemplate assignationExamMakeUpExamForUserAmqpTemplate;

    @Test
    public void assignationMakeUpExamForUserTest() throws Exception {

//        AssignationMakeUpExamVo assignationMakeUpExamVo = new AssignationMakeUpExamVo();
//        assignationMakeUpExamVo.setRecruitId(1234);
//        assignationMakeUpExamVo.setCourseId(35743);
//        assignationMakeUpExamVo.setOldExamId(5566);
//        assignationMakeUpExamVo.setUserId(163574L);
//        assignationMakeUpExamVo.setMakeUpExamId(6655);
//        assignationMakeUpExamVo.setStartTimeStr("2018-11-30 00:00:00");
//        assignationMakeUpExamVo.setEndTimeStr("2018-12-06 23:59:59");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("userId",13);
        map.put("recruitId",9348623);
        map.put("courseId",507937);
        try{
            //Assignation* 导致onlineexam中处理消息处于unacked状态，去掉之后，消息正常消费
            assignationMakeUpExamForUserAmqpTemplate.convertAndSend("onlineExam_makeUpExamForUser_key",
                    JSONObject.toJSONString(map));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void cleanExamTest() throws Exception {
        StudiedExamMqDto studiedExamMqDto = new StudiedExamMqDto();
        studiedExamMqDto.setClassId(1);
        studiedExamMqDto.setRecruitId(2);
        studiedExamMqDto.setUserId(2L);
        try{
            rmqTemplate.convertAndSend("QUEUE_EXAM_CLEAN",studiedExamMqDto);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void setTimeTest() throws Exception {
        StuSetExamTime stuSetExamTime = new StuSetExamTime();
        stuSetExamTime.setCourseId(2);
        stuSetExamTime.setEndTime(new Date());
        stuSetExamTime.setExamId(1234);
        stuSetExamTime.setRecruitId(12);
        try{
            setTimeAmqpTemplate.convertAndSend("onlineExam_setTime_key",JSONObject.toJSONString(stuSetExamTime));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void doStudentExamRecord() throws Exception {
        StuSetExamTime stuSetExamTime = new StuSetExamTime();
        stuSetExamTime.setCourseId(2);
        stuSetExamTime.setEndTime(new Date());
        stuSetExamTime.setExamId(1234);
        stuSetExamTime.setRecruitId(12);
        try{
            doStudentExamRecordAmqpTemplate.convertAndSend("onlineExam_doExam_record_key"
                    ,JSONObject.toJSONString(stuSetExamTime));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void asyncSubmitStudentExamTest() throws Exception {

        try{
            asyncSubmitStudentExamAmqpTemplate.convertAndSend("onlineExam_exam_submit_key"
                    ,"学生考试异步提交amqp消费");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void examAndMakeupExamTest() throws Exception {

        try{
            assignationExamMakeUpExamForUserAmqpTemplate.convertAndSend("onlineExam_exam_makeUpExamForUser_key"
                    ,"学生补正常考试卷和补考卷消费");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
