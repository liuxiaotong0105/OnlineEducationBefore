package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@MapperScan("com.jk.mapper")  //扫描持久层
public class EduBeforeClient {

    public static void main(String[] args) {
        SpringApplication.run(EduBeforeClient.class, args);
    }
}
