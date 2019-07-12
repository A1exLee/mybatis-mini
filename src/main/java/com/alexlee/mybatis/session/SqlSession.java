package com.alexlee.mybatis.session;

import com.alexlee.blog.BlogMapper;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 21:46
 */
public interface SqlSession {

    public <T> T selectOne(String statement, Object[] parameter, Class pojo);

    <T> T getMapper(Class<T> blogMapperClass);
}
