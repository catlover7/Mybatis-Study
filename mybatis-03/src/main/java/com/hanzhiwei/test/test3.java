package com.hanzhiwei.test;

import com.hanzhiwei.dao.TeacherMapper;
import com.hanzhiwei.pojo.Teacher;
import com.hanzhiwei.utils.MybatisUtils;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-17-10:42
 */
public class test3 {
    public static void main(String[] args) {
        Teacher teacher3 = MybatisUtils.getSqlSession().getMapper(TeacherMapper.class).getTeacher3(1);
        System.out.println(teacher3);
    }
}
