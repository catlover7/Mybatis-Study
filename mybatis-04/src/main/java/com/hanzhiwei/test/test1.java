package com.hanzhiwei.test;

import com.hanzhiwei.dao.BolgMapper;
import com.hanzhiwei.pojo.Blog;
import com.hanzhiwei.utils.MybatisUtils;
import com.hanzhiwei.utils.getBlogId;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author 韩志伟
 * @Description 实现动态sql
 * @create 2021-10-17-13:05
 */
public class test1 {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BolgMapper mapper = sqlSession.getMapper(BolgMapper.class);
        Blog blog = new Blog();
        blog.setId(getBlogId.getid());
        blog.setAuthor("hanhzi");
        blog.setCreateTime(new Date());
        blog.setTitle("mysql is easy");
        blog.setViews(21);
        mapper.insertBlog(blog);

        blog.setTitle("apache");
        blog.setViews(20);
        mapper.insertBlog(blog);


        blog.setTitle("maven");
        blog.setViews(19);
        mapper.insertBlog(blog);



        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testblogif(){
        HashMap map = new HashMap();
        map.put("author","hanhzi");
        map.put("title","apache");
        List<Blog> blogs = MybatisUtils.getSqlSession().getMapper(BolgMapper.class).queryBywhere(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        MybatisUtils.getSqlSession().close();
    }
}
