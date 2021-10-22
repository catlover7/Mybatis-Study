package com.hanzhiwei.dao;

import com.hanzhiwei.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-16-19:51
 */

public interface TeacherMapper {
    @Select("select * from mybatis.teacher ")
    Teacher getTeacher();


//获取指定老师下的所有学生和老师的信息
    Teacher getTeacher2( int id);

    Teacher getTeacher3(@Param("tid") int id);
}
