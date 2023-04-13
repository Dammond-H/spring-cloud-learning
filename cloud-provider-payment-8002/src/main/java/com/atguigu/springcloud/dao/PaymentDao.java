package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 15:16
 * @description
 */
@Mapper
@Repository
public interface PaymentDao {
    int insert(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
