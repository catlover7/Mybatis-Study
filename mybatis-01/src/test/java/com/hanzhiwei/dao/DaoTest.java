package com.hanzhiwei.dao;

import com.hanzhiwei.pojo.User;
import com.hanzhiwei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-01-21:54
 */
public class DaoTest {
    @Test
    public void test() throws IOException {
        //1.获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql 方式1 通过getMapper()
        UserMapper userdao = sqlSession.getMapper(UserMapper.class);
        List<User> user = userdao.getUser();
        for(User u:user){
            System.out.println(u);
        }
        sqlSession.close();
    }
}
