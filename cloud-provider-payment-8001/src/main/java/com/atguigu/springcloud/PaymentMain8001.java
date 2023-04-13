package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 14:52
 * @description
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
@EnableEurekaClient    // 标识当前为Eureka的provider点
@EnableDiscoveryClient // 发现Eureka上的provider信息
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
