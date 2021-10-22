package com.hanzhiwei.test;

import com.hanzhiwei.dao.TeacherMapper;
import com.hanzhiwei.pojo.Teacher;
import com.hanzhiwei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-17-10:17
 */
public class test2 {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher2 = mapper.getTeacher2(1);
        System.out.println(teacher2);
    }

}
