package com.hanzhiwei.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-17-12:54
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
