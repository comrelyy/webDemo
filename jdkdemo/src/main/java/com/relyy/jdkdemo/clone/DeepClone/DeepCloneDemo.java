package com.relyy.jdkdemo.clone.DeepClone;

public class DeepCloneDemo {

    public static void main(String[] args) throws Exception{
        /**
         * 实现Cloneable接口 深复制
         */

        TeacherVO vo1 = new TeacherVO();
        Course course = new Course();
        course.setSubject("english");
        vo1.setId(1);
        vo1.setTeacherName("yy");
        vo1.setCourse(course);

        TeacherVO vo2 = (TeacherVO)vo1.clone();
        System.out.println(vo1+"-----"+vo1.getCourse().getSubject());
        System.out.println(vo2+"-----"+vo2.getCourse().getSubject());

        course.setSubject("chinese");
        vo2.setId(2);
        System.out.println(vo1+"-----"+vo1.getCourse().getSubject());
        System.out.println(vo2+"-----"+vo2.getCourse().getSubject());
    }
}
