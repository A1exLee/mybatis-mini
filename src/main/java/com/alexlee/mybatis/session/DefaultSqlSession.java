package com.alexlee.mybatis.session;

import com.alexlee.mybatis.executor.Executor;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 22:03
 */
public class DefaultSqlSession implements SqlSession {
    private final Configuration configuration;
    private final Executor executor;


    public DefaultSqlSession(Configuration configuration, Executor executor) {
    this.configuration=configuration;
    this.executor=executor;
    }

    public <T> T selectOne(String statement, Object[] parameter, Class pojo)  {
        String sql = getConfiguration().getMappedStatement(statement);
        return executor.query(sql, parameter, pojo);
    }

    @Override
    public <T> T getMapper(Class<T> blogMapperClass) {
        return configuration.getMapper(blogMapperClass,this);
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
