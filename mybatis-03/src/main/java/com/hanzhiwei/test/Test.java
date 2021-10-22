package com.hanzhiwei.test;

import com.hanzhiwei.dao.StudentMapper;
import com.hanzhiwei.dao.TeacherMapper;
import com.hanzhiwei.pojo.Student;
import com.hanzhiwei.pojo.Teacher;
import com.hanzhiwei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-16-19:58
 */
public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher = mapper.getTeacher();
//        System.out.println(teacher);


//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> student =   mapper.getStudent();
//        for (Student stu : student) {
//            System.out.println(stu);
//        }
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();
        for (Student stu : student) {
            System.out.println(stu);
        }
        sqlSession.close();
    }


}

