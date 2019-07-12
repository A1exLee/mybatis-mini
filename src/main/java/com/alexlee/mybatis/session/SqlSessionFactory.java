package com.alexlee.mybatis.session;

import com.alexlee.mybatis.executor.Executor;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 21:47
 */
public class SqlSessionFactory {
    private final Configuration configuration;

    public SqlSessionFactory(Configuration configuration){
        this.configuration=configuration;
    }

    public SqlSession openSession(){
       return openSessionFromDataSource();
    }

    private SqlSession openSessionFromDataSource() {
        Executor executor=configuration.newExecutor();
        return new DefaultSqlSession(configuration,executor);
    }


}
