package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 黄林强
 * @version 1.0
 * @date 2023/4/13 16:50
 * @description
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstances); // 获取当前注册中心上的服务器节点(Provider)
}
