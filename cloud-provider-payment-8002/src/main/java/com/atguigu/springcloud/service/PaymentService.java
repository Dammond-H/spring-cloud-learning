package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 15:13
 * @description
 */

public interface PaymentService {
    int insert(Payment payment);
    Payment getPaymentById(Long id);
}
