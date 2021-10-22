package com.hanzhiwei.dao;

import com.hanzhiwei.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-01-21:41
 */
public interface UserMapper {
    //获取用户的信息
    List<User> getUser();
    //通过id得到User
    User getUserbyid(int id);

    //插入一个用户
    void insert(User user);

    //更新用户信息
    void UpdateUser(User user);

    //通过map取出一个User
    User getUserByMap(Map map);

    //limit获取用户
    List<User> getUserLimit(Map map);
}
