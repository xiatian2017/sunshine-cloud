package com.csd.sunshine.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        logger.info("enter interceptor");

        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/webapi/**");

    }
}
