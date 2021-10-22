package com.hanzhiwei.dao;

import com.hanzhiwei.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-17-12:56
 */
public interface BolgMapper {
    //插入blog表中数据
    int insertBlog(Blog blog);

    List<Blog> queryByIf(Map map);

    List<Blog> queryBywhere(Map map);
}
