package com.relyy.jdkdemo.clone;

import java.lang.reflect.Constructor;

public class ReflectDemo {

    public static void main(String[] args) throws Exception{

        Class clazz = VoDemo.class;

//        Field[] fields = clazz.getDeclaredFields();
//        System.out.println(fields.length);
//        for (int i = 0 , len = fields.length; i < len ; i++){
//            Field f = fields[i];
//            System.out.println(f.getName());
//        }

//        Method[] methods = clazz.getMethods();
//
//        VoDemo vo = new VoDemo();
//
//        Method m1 = clazz.getMethod("setName",String.class);
//        m1.invoke(vo,"yy");
//
//        Method m2 = clazz.getMethod("getName");
//        Object result = m2.invoke(vo);
//
//        System.out.println(result.toString());

//        System.out.println(methods.length);
//        for (int i = 0 , len = methods.length; i < len ; i++){
//            Method m = methods[i];
//            System.out.println(m.getName());
//        }
        //System.out.println(vo.toString());

        Constructor c1 = clazz.getConstructor();
        Object o1 = c1.newInstance();

    }
}
