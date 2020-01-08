package com.oracle.springbootrest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oracle.springbootrest.mapper")
public class SpringbootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestApplication.class, args);
    }

}
