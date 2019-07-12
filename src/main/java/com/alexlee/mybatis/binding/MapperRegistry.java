package com.alexlee.mybatis.binding;

import com.alexlee.mybatis.session.DefaultSqlSession;
import com.alexlee.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/12 10:49
 */
public class MapperRegistry {

    private final Map<Class<?>, MapperProxyFactory> knownMappers = new HashMap<>();
    public <T> void addMapper(Class<T> clazz, Class pojo){
        knownMappers.put(clazz, new MapperProxyFactory(clazz, pojo));
    }
    public <T> T getMapper(Class<T> clazz, DefaultSqlSession sqlSession) {
        MapperProxyFactory proxyFactory = knownMappers.get(clazz);
        if (proxyFactory == null) {
            throw new RuntimeException("Type: " + clazz + " can not find");
        }
        return (T)proxyFactory.newInstance(sqlSession);
    }
}
