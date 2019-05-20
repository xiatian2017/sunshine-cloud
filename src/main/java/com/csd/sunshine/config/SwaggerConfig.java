package com.csd.sunshine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * swgger接口
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("yjt")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.blackfox.yjt.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
//        StringBuilder sb = new StringBuilder("接口描述:");
//        sb.append(String.format("默认返回值格式为:{\"status\":\"0\",\"message\":\"OK\",\"data\":\"{}\"}, status为错误码,message为错误信息,data为携带数据."));
//        System.out.println(sb.toString());

        return new ApiInfoBuilder()
                .title("接口描述1.0 ")
                .description("")
                .contact(new Contact("yjt", null, null))
                .termsOfServiceUrl("")
                .version("v1.0")
                .build();
    }
}
