package com.hanzhiwei.test;

import com.hanzhiwei.dao.UserMapper;
import com.hanzhiwei.pojo.User;
import com.hanzhiwei.utils.MybatisUtils;
import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-02-9:25
 */
public class mybatis01Test {
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

    @Test
    public void test2(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User userbyid = userDao.getUserbyid(10);
        System.out.println(userbyid);
        sqlSession.close();

    }
    //增删改需要提交事务
    @Test
    public void test3(){



        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insert(new User(23,"hzn","23141341"));
        sqlSession.commit();
        sqlSession.close();;
    }
    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.UpdateUser(new User(2,"fafafa","23144141"));
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("userid",2);
        User userByMap = mapper.getUserByMap(map);
        System.out.println(userByMap);
        sqlSession.commit();
        sqlSession.close();

    }

}
