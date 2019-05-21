package com.csd.sunshine;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.sql.DataSource;

/**
 * 启动类
 * @Description: sunshine
 * @EnglishName LuKe
 * @author liuqi
 * @date 2019.5.16
 */
//启动类
@EnableSwagger2
@SpringBootApplication
//包扫描
@MapperScan(basePackages = {"com.csd.sunshine.mapper"})
@RequestMapping(value = "/")
public class SunApp implements ApplicationContextAware {

    public static void main(String[] args) {

        SpringApplication.run(SunApp.class, args);

        System.out.println("阳光小天使");
    }

    //applicationContext
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //加载dataSource
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource((DataSource) applicationContext.getBean("dataSource"));
        return sessionFactoryBean.getObject();
    }


}
