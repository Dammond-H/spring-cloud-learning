package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/14 20:45
 * @description
 */
@SpringBootApplication
@EnableEurekaClient // 注入到eureka注册中心中
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}
