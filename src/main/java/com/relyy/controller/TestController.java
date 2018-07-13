package com.relyy.controller;

import com.relyy.VO.Json;
import com.relyy.VO.MissionDetail;
import com.relyy.dao.MissionDetailMapper;
import com.utils.Decrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Test")
class TestController{

    @Autowired
    private MissionDetailMapper missionDetailMapper;


@ResponseBody
@RequestMapping("/testDemo")
public Json testDemo(Long id, String name, Integer age){
    Json json = new Json();

   Map<String,Object> rt = new HashMap<String,Object>();
    rt.put("userId","");
    rt.put("uuid","");
    rt.put("list","");

    json.setSuccessValue(rt);
    return json;
   }

    /**
     * @desc
     * @author: cairuirui
     * @reate: a
     */
    @ResponseBody
    @RequestMapping("/testbatch")
    public Json testbatch() {
        //logger.info(, "");
        Json json = new Json();

        try {
            //int i = 370470;
            List<MissionDetail> list = new ArrayList<>();
            MissionDetail vo = null;
            for (int i = 370468; i <= 370470; i++) {
                vo = new MissionDetail();
                vo.setExamId(i);
                vo.setStudentExamId(370468);
                list.add(vo);
            }
            missionDetailMapper.batchUpdateStuExamIdByExamId(list);
            json.setSuccessValue("ok");
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue("no");
            //logger.error(, "", e);
        }

        return json;
    }

    /**
     * @desc
     * @author: cairuirui
     * @creae: a
     */
    @ResponseBody
    @RequestMapping("/getEncrypt")
    public Json getEncrypt(Integer examId,Integer recruitId) {

        Json json = new Json();
        try {
            String params = recruitId+";"+examId+";0";
            String ev = Decrypt.encrypt(params);
            json.setSuccessValue(ev);
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue("");

        }
        return json;
    }
}
