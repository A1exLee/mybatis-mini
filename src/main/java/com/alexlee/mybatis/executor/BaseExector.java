package com.alexlee.mybatis.executor;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 21:56
 */
public class BaseExector implements Executor {
    @Override
    public <T> T query(String sql, Object[] param, Class pojo) {
        StatementHandler statementHandler = new StatementHandler();
        return statementHandler.query(sql, param, pojo);
    }
}
