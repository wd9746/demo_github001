package com.dt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: springcloud2020
 * @ClassName: OrderHystrixMain80
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/31 23:12
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixFeignMain80.class, args);
    }
}
