package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/14 20:22
 * @description
 */
@SpringBootApplication
@EnableConfigServer // 开启Config中心配置服务
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
