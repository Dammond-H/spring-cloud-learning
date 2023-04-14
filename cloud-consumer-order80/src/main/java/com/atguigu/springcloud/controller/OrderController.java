package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 16:55
 * @description
 */
@RestController
@Slf4j
public class OrderController {
    //private static final String PAYMENT_URL = "http://localhost:8002";  // 单机版
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";// 通过eureka的service name获取相应的provider

    @Autowired
    private RestTemplate restTemplate; // 远程调用

    @Autowired
    private LoadBalance loadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/insert")
    public CommonResult insert(Payment payment) {
        // 调用cloud-provider-payment-8001提供者服务，Post请求
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        // 调用cloud-provider-payment-8001提供者服务,Get请求
        log.info("{}/payment/getPayment/{}", PAYMENT_URL, id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPayment/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentEntities/{id}")
    public CommonResult getPaymentEntities(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entities = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPayment/" + id, CommonResult.class);
        if(entities.getStatusCode().is2xxSuccessful()) {
            return entities.getBody(); // 返回JSON格式
        }else{
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"); // 获取providers
        if(instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }


}
