package com.coder.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableCaching
//开启SpringSecurity权限注解开关
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("com.coder.service.mapper")
public class CoderHomeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoderHomeServiceApplication.class, args);
    }
}
