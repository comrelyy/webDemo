package com.relyy.controller;

import com.relyy.VO.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-02
 */
@Controller
@RequestMapping("nima")
public class NimaController {
    /**
     * @desc
     * @author: cairuirui
     * @create: 2018
     */
    @ResponseBody
    @RequestMapping("/login")
    public Json login(String appId,String code,String state) {

        Json json = new Json();
        try {
            System.out.println("appId:"+appId);
            System.out.println("code:"+code);
            System.out.println("state:"+state);
            json.setSuccessValue(1674964);
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue("");
        }

        return json;
    }


}
