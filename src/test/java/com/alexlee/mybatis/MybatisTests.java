package com.alexlee.mybatis;

import com.alexlee.blog.Blog;
import com.alexlee.blog.BlogMapper;
import com.alexlee.mybatis.session.SqlSession;
import com.alexlee.mybatis.session.SqlSessionFactory;
import com.alexlee.mybatis.session.SqlSessionFactoryBuilder;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 21:48
 */
public class MybatisTests {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog result = blogMapper.selectByConditionLimit1();
        System.out.println(result.toString());
    }


}
