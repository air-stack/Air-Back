package com.ten.air.back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.ten.air.back.dao")
public class AirBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirBackApplication.class, args);
    }
}
