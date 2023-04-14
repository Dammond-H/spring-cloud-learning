package com.atguigu.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/14 19:23
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMain {

    @Test
    public void test1() {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }

}
