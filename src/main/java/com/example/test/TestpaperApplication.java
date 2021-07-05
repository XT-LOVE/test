package com.example.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("com.example.test.dao")
//@ComponentScan(basePackages = { "com.example.test.service.*" })
@SpringBootApplication()

public class TestpaperApplication {
    public static void main(String[] args) { SpringApplication.run(TestpaperApplication.class, args);
    }
}
