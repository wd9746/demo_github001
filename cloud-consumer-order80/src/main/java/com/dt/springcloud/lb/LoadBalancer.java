package com.dt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ProjectName: springcloud2020
 * @ClassName: LoadBalancer
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/29 17:00
 */
public interface LoadBalancer {

    /**
     * @param serviceInstances 传入所有服务的实例总数
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
