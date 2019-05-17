package com.csd.sunshine.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description 获取spring 容器
 * @author liuqi
 * @date 2019/5/17 18:58
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    private ApplicationContextUtil() { }
}
