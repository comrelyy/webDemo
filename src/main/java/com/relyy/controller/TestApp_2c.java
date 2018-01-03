package com.relyy.controller;
import com.relyy.VO.*;
import com.utils.BeanConvert2Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/testapp")
public class TestApp_2c {
    @ResponseBody
    @RequestMapping("/getIfCourseChange")
    public Json getIfCourseChange(@RequestParam("userId") Long userId,
                                  @RequestParam("schoolId") Integer schoolId,
                                  @RequestParam("courseIdList") String courseIdList,
                                  @RequestParam("recruitIdList") String recruitIdList) {

        Json json = new Json();

        try {
//                   StudentInfoOpenDto dto = new StudentInfoOpenDto();
//                    dto.setUserId(userId);
//                    dto.setSchoolId(schoolId);
//                    dto.setRecruitId(courseIdList);
//                    dto.setCourseId(recruitIdList);
            //List<Long> courseList = courseIdList.getCourseIdList();
            //List<Integer> recruitList = recruitIdList.getRecruitIdList();
           // boolean flag = courseList.size() == recruitList.size() ? true : false;

            System.out.println(courseIdList);

            List<Long> list = JSONArray.parseArray(courseIdList,Long.class);

            for (Long courseId : list){
                System.out.println(courseId);
            }



               // ResultWrapper<CourseChangeOpenDto> rw = studyGameForAppService.getIfCourseChange(studentList);

                if (true) {
                    CourseChangeOpenDto courseChangeOpenDto = new CourseChangeOpenDto();
                     /*供测试*/
                    courseChangeOpenDto.setAddCourse(0);
                    courseChangeOpenDto.setAddMission(0);
                    courseChangeOpenDto.setDelCourse(0);
                    courseChangeOpenDto.setDelMission(0);

                   // courseChangeOpenDto = rw.getResult();


                    if(courseChangeOpenDto != null){
                        json.setSuccessValue(courseChangeOpenDto);
                    }else{
                        json.setExceptionValue("获取学生课程改变信息结果为空!");
                        //logger.error(missionBuilder,"获取学生课程改变信息结果为空!");
                    }
                } else {
                    json.setExceptionValue("获取学生课程改变信息返回为空!");
                    //logger.error(missionBuilder,"获取学生课程改变信息返回为空!");
                }


        }catch (Exception e){
            e.printStackTrace();
            //json.setExceptionValue("调用获取学生课程改变信息接口异常!");
            //logger.error(missionBuilder,"调用获取学生课程改变信息接口异常!",e);
        }
        return json;

    }

    /**
     * @desc
     * @author: cairuirui
     * @create: ${DATE}
     */
    @ResponseBody
    @RequestMapping("/covert2MapTest")
    public Json covert2MapTest() {
        //logger.info(, "");
        Json json = new Json();

        try {

            Map<String,Object> map = new HashMap<String, Object>();
            UserVO vo = new UserVO();
            vo.setId(25);
            vo.setName("relyy");
            vo.setCreateTime(new Date());
            String[] key = {"id","name","createTime"};

            BeanConvert2Map.dtoCovert2Map(map,key,vo);

            if (null != map) {
                for (Map.Entry<String,Object> entry : map.entrySet()){
                    System.out.println(entry.getKey()+":"+entry.getValue());
                }
            }

            json.setSuccessValue(map);
            System.out.println(json.toString());

        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue("");
            //logger.error(, "", e);
        }

        return json;
    }

}
