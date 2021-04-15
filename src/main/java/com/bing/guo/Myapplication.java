package com.bing.guo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.bong.guo.mapper")
@EnableTransactionManagement // 开启事务
@EnableAsync // 开启异步任务
public class Myapplication {
    public static void main(String[] args) {
        SpringApplication.run(Myapplication.class,args);
    }
}
