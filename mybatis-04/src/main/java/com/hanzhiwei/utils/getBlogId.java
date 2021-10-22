package com.hanzhiwei.utils;

import java.util.UUID;

/**
 * @author 韩志伟
 * @Description 使用UUID工具类得到随机id
 * @create 2021-10-17-12:59
 */
public class getBlogId {
    static public String getid(){
    return UUID.randomUUID().toString().replace("-","");

    }

    public static void main(String[] args) {
        String getid = getBlogId.getid();
        System.out.println(getid);
    }
}
