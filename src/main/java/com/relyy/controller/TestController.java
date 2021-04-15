package com.relyy.controller;

import com.relyy.VO.Json;
import com.utils.Decrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/test")
class TestController{

//    @Autowired
//    private MissionDetailMapper missionDetailMapper;


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
//    @ResponseBody
//    @RequestMapping("/testbatch")
//    public Json testbatch() {
//        //logger.info(, "");
//        Json json = new Json();
//
//        try {
//            //int i = 370470;
//            List<MissionDetail> list = new ArrayList<>();
//            MissionDetail vo = null;
//            for (int i = 370468; i <= 370470; i++) {
//                vo = new MissionDetail();
//                vo.setExamId(i);
//                vo.setStudentExamId(370468);
//                list.add(vo);
//            }
//            missionDetailMapper.batchUpdateStuExamIdByExamId(list);
//            json.setSuccessValue("ok");
//        } catch (Exception e) {
//            e.printStackTrace();
//            json.setExceptionValue("no");
//            //logger.error(, "", e);
//        }
//
//        return json;
//    }

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

    /**
     * @desc
     * @author: cairuirui
     * @create: 2018
     */
    @ResponseBody
    @RequestMapping("/countDownLatchTest")
    public Json countDownLatchTest() {

        Json json = new Json();
        try {
            List<VoDemo> voDemos = new ArrayList<VoDemo>();
            voDemos.add(new VoDemo("2"));
            voDemos.add(new VoDemo("3"));
            voDemos.add(new VoDemo("4"));
            voDemos.add(new VoDemo("5"));
            voDemos.add(new VoDemo("6"));
            voDemos.add(new VoDemo("7"));
            voDemos.add(new VoDemo("8"));
            voDemos.add(new VoDemo("9"));
            voDemos.add(new VoDemo("10"));
            voDemos.add(new VoDemo("11"));
            voDemos.add(new VoDemo("12"));
            voDemos.add(new VoDemo("13"));
            voDemos.add(new VoDemo("14"));
            //System.out.println("执行前："+voDemos.toString());
            long time1 = System.currentTimeMillis();
            System.out.println("执行时间："+time1);
            CountDownLatch countDownLatch = new CountDownLatch(voDemos.size());

            ExecutorService executorService = Executors.newFixedThreadPool(voDemos.size());
            for (VoDemo voDemo : voDemos) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        String name = voDemo.getName();
                        voDemo.setId(Integer.parseInt(name));
                        countDownLatch.countDown();
                        System.out.println(countDownLatch.getCount());
                        try{
                            Thread.sleep(10000);
                        }catch(Exception e){
                            e.printStackTrace();
                        }

                    }
                });
            }

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.shutdown();
            System.out.println("执行时间："+(System.currentTimeMillis()-time1));
            System.out.println("执行后："+voDemos.toString());
            json.setSuccessValue(voDemos);
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue("");
        }

        return json;
    }
}
