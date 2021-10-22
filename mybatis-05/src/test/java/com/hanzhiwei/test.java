package com.hanzhiwei;

import com.hanzhiwei.dao.UserMapper;
import com.hanzhiwei.pojo.User;
import com.hanzhiwei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 韩志伟
 * @Description 缓存：.存在内存中的临时数据 减少与数据库交互次数，减少系统开销，提高系统效率
 * 什么样的数据能使用缓存：经常查询而且不经常改变的数据
 *
 * 缓存失效情况：
 * 1查询不同的东西
 * 2.增删改操作，可能会改变原来的数据，所有必定会刷新缓存
 * 3.查询不同的Mapper.xml
 * 4.手动清理缓存
 * 一级缓存是开启的，只在一次sqlsession中有效，也就是拿到连接到关闭连接这个区间
 * @create 2021-10-18-8:45
 */
public class test {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser(2);

        System.out.println(user);
        sqlSession.clearCache();//手动清理缓存

        User user1 = mapper.getUser(2);

        System.out.println(user1);
        System.out.println(user==user1);
       sqlSession.close();

    }
}
