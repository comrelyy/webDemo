package com.relyy.jdkdemo.clone.ShallowClone;

public class ShallowCloneDemo {

    public static void main(String[] args) throws Exception{

        StudentVO vo1 = new StudentVO();
        Address addre = new Address();
        addre.setAddre("jingan");
        vo1.setId(1);
        vo1.setStuName("yy");
        vo1.setAddress(addre);

        StudentVO vo2 = (StudentVO)vo1.clone();
        System.out.println(vo1);
        System.out.println(vo2);

        addre.setAddre("tianjin");
        vo2.setId(2);
        vo2.setAddress(addre);
        System.out.println(vo1);
        System.out.println(vo2);
    }
}
