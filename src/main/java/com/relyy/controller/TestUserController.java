package com.relyy.controller;

import com.relyy.VO.Json;
import com.relyy.service.ITestService;
import org.omg.CORBA.Environment;
import org.springframework.context.EnvironmentAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器
 *
 * @author cairuirui
 * @date 2017-10-17
 */
@Controller
@RequestMapping("/test")
public class TestUserController implements EnvironmentAware {

    @Resource
    private ITestService testService;

    @ResponseBody
    @RequestMapping("/getUser")
    public Json getUser(Integer id) {

        Json json = new Json();

        try {
            json.setSuccessValue(testService.getUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue(e);
            //logger.error(, "", e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/testFilter")
    public Json testFilter(String uuid,Integer flag) {
        //logger.info(, "");
        Json json = new Json();

        try {
            System.out.println("测试参数----uuid"+uuid);
            System.out.println("测试参数----flag"+flag);
            System.out.println("为了测试过滤器");

        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue("");
            //logger.error(, "", e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/testInterceptor")
    public Json testInterceptor(String uuid,String flag) {
        //logger.info(, "");
        Json json = new Json();

        try {
            System.out.println("测试参数----uuid"+uuid);
            System.out.println("为了测试拦截器");
            json.setSuccessValue(true);
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue("");
            //logger.error(, "", e);
        }
        return json;
    }

    private org.springframework.core.env.Environment environment;
    @Override
    public void setEnvironment(org.springframework.core.env.Environment environment) {
        this.environment=environment;
    }
}
