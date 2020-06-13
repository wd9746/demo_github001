package com.dt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: springcloud2020
 * @ClassName: GatewayMain9528
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/3 17:00
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9528 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9528.class,args);
    }
}
