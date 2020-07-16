package com.atguigu.mpdemo1010;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.atguigu.mpdemo1010.mapper")
@EnableSwagger2
public class Mpdemo1010Application {
    public static void main(String[] args) {
        SpringApplication.run(Mpdemo1010Application.class, args);
    }
}
