/**
 * <pre>项目名称:before-consumer
 * 文件名称:PropertiesConfig.java
 * 包名:com.jk.config
 * 创建日期:2018年9月18日下午3:18:36
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre>
 */
package com.jk.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <pre>项目名称：before-consumer
 * 类名称：PropertiesConfig
 * 类描述：
 * 创建人：张培科
 * 创建时间：2018年9月18日 下午3:18:36
 * 修改人：
 * 修改时间：2018年9月18日 下午3:18:36
 * 修改备注：
 * @version </pre>
 */
@Component
public class PropertiesConfig implements ApplicationListener {
    //保存加载配置参数
    private static Map<String, String> aliPropertiesMap = new HashMap<String, String>();

    /*获取配置参数值*/
    public static String getKey(String key) {
        return aliPropertiesMap.get(key);
    }

    /*监听启动完成，执行配置加载到aliPropertiesMap*/
    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof ApplicationReadyEvent) {
            this.init(aliPropertiesMap);//应用启动加载
        }
    }

    /*初始化加载aliPropertiesMap*/
    public void init(Map<String, String> map) {
        // 获得PathMatchingResourcePatternResolver对象
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //加载resource文件(也可以加载resources)
            Resource resources = resolver.getResource("classpath:config/alipay.properties");
            PropertiesFactoryBean config = new PropertiesFactoryBean();
            config.setLocation(resources);
            config.afterPropertiesSet();
            Properties prop = config.getObject();
            //循环遍历所有得键值对并且存入集合
            for (String key : prop.stringPropertyNames()) {
                map.put(key, (String) prop.get(key));
            }
        } catch (Exception e) {
            new Exception("配置文件加载失败");
        }
    }
}
