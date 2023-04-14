package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/13 19:28
 * @description 远程调用方法
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") // provider的名称
public interface PaymentFeignService {

    @GetMapping(value = "/payment/getPayment/{id}")  // 远程调用 端口为8001/8002中的 url = /payment/getPayment/{id}
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
