package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 20:51
 * @description
 */

@SpringBootApplication
@EnableEurekaServer // 作为Eureka服务器，提供注册中心
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
