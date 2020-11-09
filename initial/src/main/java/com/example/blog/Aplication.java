package com.example.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 启动类
* */

@SpringBootApplication
@MapperScan("com.pandy.blog.dao")
public class Aplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(Aplication.class,args);
    }
}
