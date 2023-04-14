package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/14 15:43
 * @description
 */

@SpringBootApplication
@EnableHystrixDashboard // 开启监控注解，访问路径：http://localhost:9001/hystrix
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
