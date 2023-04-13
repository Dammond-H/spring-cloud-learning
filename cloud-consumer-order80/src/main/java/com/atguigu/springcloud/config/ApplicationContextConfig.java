package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 16:59
 * @description
 */
@ComponentScan(basePackages = {"com.atguigu.springcloud"})
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced // 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力，让Order通过相应策略自己选择provider（默认为轮询策略）
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
