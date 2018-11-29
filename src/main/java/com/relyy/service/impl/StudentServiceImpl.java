package com.relyy.service.impl;

import com.relyy.VO.Student;
import com.relyy.service.IStudentService;
import com.relyy.shardingMapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/29
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0 ? true : false;
    }
}
