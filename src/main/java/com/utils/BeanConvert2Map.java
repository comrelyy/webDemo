package com.utils;

import com.relyy.VO.Json;
import net.sf.json.*;
import com.relyy.VO.UserVO;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 将对象的属性名和值转化为map形式返回
 *
 * @author cairuirui
 * @date 2017-10-17
 */
public class BeanConvert2Map {

    /**
     * @desc 将对象对应的属性名和值，以key-value的形式返回
     * @author: cairuirui
     * @date 2017-10-17
     * @param obj
     * @param paramList
     * @return
     */
    public static Map<String, Object> allFieldConvert(Object obj,List<String> paramList){
        Map<String, Object> valueMap = new HashMap<String, Object>();

        Class clazz = obj.getClass();
        List<String> fieldList = getFieldNameList(clazz);
        try{

            Object value = null;
            for (String param : paramList){

                if (fieldList.contains(param)) {
                    Method method = clazz.getMethod("get" + param.substring(0, 1).toUpperCase() + param.substring(1));
                    value = method.invoke(obj);
                    valueMap.put(param,value);
                }else {
                    valueMap.put(param,null);
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return valueMap;
    }

    /**
     * @desc 获取对象的所有属性
     * @author: cairuirui
     * @date 2017-10-10
     * @param clazz
     * @return
     */
    public static List<String> getFieldNameList(Class clazz){
        List<String> list = new ArrayList<String>();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            list.add(field.getName());
        }
        return list;
    }

    /**
     * @desc 通过json对象转换
     * @author: cairuirui
     * @date 2017-10-17
     * @param obj
     * @param paramList
     * @return
     */
    public static Map<String, Object> covertByJson(Object obj,List<String> paramList){
        Map<String, Object> valueMap = new HashMap<String, Object>();
        JSONObject userJson = JSONObject.fromObject(obj);

        for (String param : paramList){
            Object value = userJson.get(param);

            valueMap.put(param, value);
        }

        return valueMap;
    }

    public static List<Integer> testDemo(List<Integer> testList, int limitSize){
        List<Integer> distinctB2cBaseDataList = new ArrayList<Integer>();
        Map<Integer,Integer> b2cBaseDataMap = new HashMap<Integer, Integer>();

        Integer id = testList.get(0);
        int size = testList.size();
        int length = 1;
        int end;
        for (int i = 1 ; i < size; i++){
            Integer speakerId = testList.get(i);
            if (null != id && speakerId.equals(id)){
                length++;
                if (i == size-1){
                    int index = getRandnum(size,length);
                    b2cBaseDataMap.put(index,testList.get(index));
                    System.out.println("index------"+index);
                }
            }else {
                end = i;
                id = speakerId;
                int index;
                if (length > 1) {
                    index = getRandnum(end, length);
                } else {
                    index = i - 1;
                }
                b2cBaseDataMap.put(index,testList.get(index));
                System.out.println("index------"+index);
                //最后一位老师只有一条数据时
                if (i == size-1){
                    b2cBaseDataMap.put(i,testList.get(i));
                    System.out.println("i------"+i);
                }
                length = 1;
            }
        }

        Set<Integer> keySet = b2cBaseDataMap.keySet();
        for (Integer index : keySet){
            distinctB2cBaseDataList.add(b2cBaseDataMap.get(index));
        }
        //不足5条数据时
        int subSize = limitSize - distinctB2cBaseDataList.size();
        System.out.println("subSize------"+subSize);
        while (subSize != 0){
            System.out.println("subSize------"+subSize);
            int index = getRandnum(size, size);
            if(!b2cBaseDataMap.containsKey(index)){
                subSize--;
                Integer dto = testList.get(index);
                b2cBaseDataMap.put(index,dto);
                distinctB2cBaseDataList.add(dto);
            }
        }
        return distinctB2cBaseDataList;
    }

    public static int getRandnum(int end,int length){
        int index = new Random().nextInt(length)+(end-length);
        return index;
    }

    public static void dtoCovert2Map(Map<String,Object> map,String[] keyArr,Object dtoObj){
        Assert.notNull(keyArr,"String[]参数有误！");
        Assert.notNull(dtoObj,"dtoObj参数有误！");

        try{
            Class clazz = dtoObj.getClass();
            for (int i = 0,len = keyArr.length;i < len; i++){
                String key = keyArr[i];
                Method method = clazz.getMethod("get" + key.substring(0, 1).toUpperCase() + key.substring(1));
                Object value = method.invoke(dtoObj);
                map.put(key,value);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Json json = new Json();
        Map<String,Object> map = new HashMap<String, Object>();
        UserVO vo = new UserVO();
        vo.setId(25);
        vo.setName("relyy");
        vo.setCreateTime(new Date());
        String[] key = {"id","name","createTime"};

        dtoCovert2Map(map,key,vo);

        if (null != map) {
            for (Map.Entry<String,Object> entry : map.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }

        json.setSuccessValue(map);
        System.out.println(json.toString());
    }
}
