package com.dt.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud2020
 * @ClassName: ApplicationContextConfig
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/27 17:19
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced//让RestTemplate开启负载均衡注解,还可以指定负载均衡算法,默认轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
