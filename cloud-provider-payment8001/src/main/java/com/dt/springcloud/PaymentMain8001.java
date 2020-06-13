package com.dt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentMain8001
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/27 15:24
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 开启服务发现Discovery
public class PaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }


}
