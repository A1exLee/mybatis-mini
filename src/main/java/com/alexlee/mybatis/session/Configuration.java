package com.alexlee.mybatis.session;

import com.alexlee.mybatis.binding.MapperRegistry;
import com.alexlee.mybatis.executor.BaseExector;
import com.alexlee.mybatis.executor.Executor;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author alexlee
 * @version 1.0
 * @date 2019/7/3 21:46
 */
public class Configuration {
    public static final MapperRegistry MAPPER_REGISTRY = new MapperRegistry();
    public static final Map<String, String> mappedStatements = new HashMap<>();
    public static final ResourceBundle properties; // 全局配置

    static{
        properties = ResourceBundle.getBundle("mybatis");
    }
    public Configuration(String fileName) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(Configuration.class.getClassLoader().getResourceAsStream(fileName));
            Element rootElement = document.getRootElement();
            Element mapping = rootElement.element("mappers");
            List<Element> mappers = mapping.elements("mapper");
            mappers.forEach(mapper -> {
                try {
                    String resource = mapper.attributeValue("resource");
                    Document mapperDocument = saxReader.read(Configuration.class.getClassLoader().getResourceAsStream(resource));
                    Element root = mapperDocument.getRootElement();
                    String namespace = root.attributeValue("namespace");
                    Class mapperClz = Class.forName(namespace);
                    String entity = root.attributeValue("entity");
                    Class entityClz = Class.forName(entity);
                    List<Element> selects = root.elements("select");
                    MAPPER_REGISTRY.addMapper(mapperClz, entityClz);
                    selects.forEach(select -> {
                        String id = select.attributeValue("id");
                        String sql = select.getTextTrim();
                        mappedStatements.put(mapperClz.getName() + "." + id, sql);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Executor newExecutor() {
        return new BaseExector();
    }

    public String getMappedStatement(String statementId) {
        return mappedStatements.get(statementId);
    }

    public boolean hasStatement(String statementId) {
        return mappedStatements.containsKey(statementId);
    }
    public <T> T getMapper(Class<T> clazz, DefaultSqlSession sqlSession) {
        return MAPPER_REGISTRY.getMapper(clazz, sqlSession);
    }
}
