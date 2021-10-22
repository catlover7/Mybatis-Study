package com.hanzhiwei.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 韩志伟
 * @Description每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。SqlSessionFactory 的实例可以通过
 * SqlSessionFactoryBuilder 获得
 * 而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先配置的 Configuration 实例来构建出 SqlSessionFactory 实例。
 *
 * 从 XML 文件中构建 SqlSessionFactory 的实例非常简单，建议使用类路径下的资源文件进行配置。
 * 但也可以使用任意的输入流（InputStream）实例，比如用文件路径字符串或 file:// URL 构造的输入流。MyBatis 包含一个名叫 Resources 的工具类，
 * 它包含一些实用方法，使得从类路径或其它位置加载资源文件更加容易。
 *
 *   //一直报为什么一直报ioexception can not find resource resource ,原来是resource传进来带了引号 传参时要小心
 */

public class MybatisUtils {
    private static SqlSessionFactory ssf;

    static {
        //获取SqlSessionFactory对象

        try {
            String resource = "mybatis-config.xml";
            //为什么一直报ioexception can not find resource ,原来是resource传进来带了引号
            //InputStream is = Resources.getResourceAsStream("resource");
            InputStream is = Resources.getResourceAsStream(resource);
            ssf = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //通过sqlSessionFactory获取SqlSession
    // 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = ssf.openSession();
        return sqlSession;
    }
}

//    }
    //public static SqlSession getSqlSession() throws IOException {
//       SqlSessionFactory ssf ;
//        //获取SqlSessionFactory对象
//        String resource = "mybatis-config.xml";
//
//            InputStream is = Resources.getResourceAsStream("resource");
//            ssf = new SqlSessionFactoryBuilder().build(is);
//            SqlSession sqlSession = ssf.openSession();
//
//return sqlSession;
  //  }

