package com.relyy.shardingMapper;

import com.relyy.VO.Student;
import com.relyy.VO.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/11/29
 */
@Component("studentMapper")
public interface StudentMapper {

    Integer insert(Student student);

    List<Student> findAll();

    List<Student> findByUserIds(List<Integer> studentIds);
}
