package com.dt.springcloud;

import com.dt.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ProjectName: springcloud2020
 * @ClassName: OrderMain80
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/27 17:10
 */
@SpringBootApplication
@EnableEurekaClient
//设置自定义的 Ribbon 规则
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
