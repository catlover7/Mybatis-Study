package com.hanzhiwei.test;

import java.awt.event.ItemEvent;
import java.util.ArrayList;

/**
 * @author 韩志伟
 * @Description
 * @create 2021-10-17-18:54
 */
public class createSqlByJava {
    public static void main(String[] args) {
        //查询id在idlist中的student
        //select * from student where id in (1001,1002,1003)
        ArrayList<Integer> idlist = new ArrayList<>();
        idlist.add(1001);
        idlist.add(1002);
        idlist.add(1003);

        StringBuffer sql = new StringBuffer("");
        sql.append("select * from student where id in ");
        sql.append("(");
        //使用循环把list数据追加到sql字符串中
        for (int i = 0; i <idlist.size() ; i++) {
            Integer item = idlist.get(i);//item是成员集合
            sql.append(item);//添加成员到sql字符串中
            sql.append(",");//集合成员中的分隔符

        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        System.out.println(sql);
    }
}
