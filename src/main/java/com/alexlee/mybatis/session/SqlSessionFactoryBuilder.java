package com.alexlee.mybatis.session;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 21:50
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(String configFile) {
        return new SqlSessionFactory(parse(configFile));
    }

    private Configuration parse(String configFile) {
        return new Configuration(configFile);
    }
}
