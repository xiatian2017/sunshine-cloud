package com.csd.sunshine;

import org.springframework.boot.SpringApplication;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 * @Description: sunshine
 * @EnglishName LuKe
 * @author liuqi
 * @date 2019.5.16
 */
//启动类
@EnableSwagger2
@SpringBootApplication(exclude = {PageHelperAutoConfiguration.class})
//包扫描
@MapperScan(basePackages = {"com.csd.sunshine.mapper"})
@RequestMapping(value = "/")
public class SunshineApplication {

    public static void main(String[] args) {

        SpringApplication.run(SunshineApplication.class, args);

        System.out.println("阳光小天使");
    }

}
