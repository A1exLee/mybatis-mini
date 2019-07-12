package com.alexlee.mybatis.executor;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 21:45
 */
public interface Executor {

    <T> T query(String sql, Object[] param, Class pojo);
}
