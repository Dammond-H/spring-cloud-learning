package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.atguigu.springcloud.service.PaymentService;

import java.util.List;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 15:14
 * @description
 */

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient; // 用于暴露provider的信息

    @PostMapping(value = "payment/insert")
    public CommonResult insertPayment(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        log.info("****** 插入的结果：" + insert);
        if(insert > 0) {
            return new CommonResult(200, "数据插入成功!, serverPort: " + serverPort, insert);
        }else{
            return new CommonResult(444, "数据插入失败!", null);
        }
    }

    @GetMapping(value = "payment/getPayment/{id}")
    public CommonResult GetPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****** 查询的结果：" + payment);
        if(payment != null) {
            return new CommonResult(200, "查询成功!,serverPort: " + serverPort, payment);
        }else{
            return new CommonResult(444, "没有对应的数据，查询ID：" + id, null);
        }
    }

    /**
     * @Description: 获取注册中心上相应的provider信息
     * @Date: 2023/4/13 10:07
     * @Param: []
     * @Return: java.lang.Object
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices(); // 获取注册中心中所有的servers，即providers
        for(String element: services) {
            log.info("*********element=" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");// 获取euraka注册中心中中指定的实例列表
        for(ServiceInstance instance: instances) {
            log.info("===" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort; //返回服务接口
    }
}
