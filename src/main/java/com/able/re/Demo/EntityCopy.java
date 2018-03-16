package com.able.re.Demo;

import com.able.re.clone.DeepClone.Course;
import com.able.re.clone.DeepClone.TeacherVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象复制
 *
 * @author cairuirui
 * @date 2017-12-17
 */
public class EntityCopy {

    public static void main(String[] args) throws Exception{
        Course course = new Course();
        course.setSubject("Chinese");
        TeacherVO vo1 = new TeacherVO();
        vo1.setId(1);
        vo1.setTeacherName("wang");
        vo1.setCourse(course);
        TeacherVO vo2 = (TeacherVO)vo1.clone();
        System.out.println("vo1:"+vo1.toString());
        System.out.println("vo2:"+vo2.toString());

        course.setSubject("English");
        System.out.println("vo1:"+vo1.toString());
        System.out.println("vo2:"+vo2.toString());

    }
}
