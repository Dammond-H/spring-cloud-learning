package com.atguigu.springcloud;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/12 15:57
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PayMainTest {

    @Autowired
    private PaymentDao paymentDao;

    @Test
    public void test1(){
        Payment paymentById = paymentDao.getPaymentById(1L);
        System.out.println(paymentById);
    }
}
