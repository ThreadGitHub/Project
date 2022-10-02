package com.coder.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.coder.service.mapper")
public class CoderHomeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoderHomeServiceApplication.class, args);
    }
}
