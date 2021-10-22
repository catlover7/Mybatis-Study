package com.hanzhiwei;

import com.hanzhiwei.dao.UserMapper;
import com.hanzhiwei.pojo.User;
import com.hanzhiwei.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import sun.rmi.server.UnicastServerRef;

import javax.swing.plaf.multi.MultiButtonUI;

/**
 * @author 韩志伟
 * @Description 二级缓存  默认情况下，只启用了本地的会话缓存，它仅仅对一个会话中的数据进行缓存。 要启用全局的二级缓存，
 * 只需要在你的 （Mapper.xml）SQL 映射文件中添加一行：
 * 1.开启全局缓存
 * 2.在要使用二级缓存的Mapper中开启 也可以自定义参数
 *一个会话查询一条数据，这个数据会被放到当前会话的一级缓存中
 * 如果当前会话关闭了，这个会话对应的一级缓存就没了，我们想要的是，会话关闭了，一级缓存的数据就会保存到二级缓存中去
 * 新的会话查询信息，就可以从二级缓存中获取内容
 * 不同的mapper查处的数据就会放到自己对应的缓存中（mapper）
 * @create 2021-10-18-9:06
 *
 * 小结：
 * 只要开启了二级缓存，在同一个Mapper下就有效
 * 所有的数据都先放到一级缓存中去
 * 只有当会话提交或者关闭的时候，才会提交到二级
 */
public class cache2 {
  @Test
    public void test1(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      SqlSession sqlSession1 = MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
      User user = mapper.getUser(2);
      System.out.println(user);
      sqlSession.close();

      User user1 = mapper1.getUser(2);
      System.out.println(user==user1);
      sqlSession1.close();
  }
}
