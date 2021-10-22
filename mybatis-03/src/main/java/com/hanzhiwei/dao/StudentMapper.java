package com.hanzhiwei.dao;

import com.hanzhiwei.pojo.Student;

import java.util.List;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-16-19:51
 */
public interface StudentMapper {
    List<Student> getStudent();

    List<Student> getStudent2();
}
