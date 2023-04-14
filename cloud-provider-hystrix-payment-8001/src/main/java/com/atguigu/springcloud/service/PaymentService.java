package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/13 20:48
 * @description
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentInfo_TimeOutHandler(Integer id);

    String paymentCircuitBreaker(@PathVariable("id") Integer id);

}
