package com.atguigu.mpdemo1010.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/7/16 11:36
 * @Version 1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atguigu.mpdemo1010.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        //题目
                        .title("SpringBoot整合Swagger")
                        //描述
                        .description("SpringBoot整合Swagger，详细信息......")
                        //版本号
                        .version("1.0")
                        .contact(new Contact("邮箱","https://blog.csdn.net/weixin_43610698","hengheng.com"))
                        .license("博客地址")
                        .licenseUrl("https://blog.csdn.net/weixin_43610698")
                        .build());
    }
}

