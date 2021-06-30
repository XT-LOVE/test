package com.example.test;

import com.example.test.entity.Paper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.example.test.dao")
@SpringBootApplication()

public class TestpaperApplication {
    public static void main(String[] args) { SpringApplication.run(TestpaperApplication.class, args);
    }
}
