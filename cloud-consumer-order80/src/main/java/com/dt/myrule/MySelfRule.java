package com.dt.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  ribbon 负载规则设置为自定义配置类不能放在 @ComponentScan 所扫描的当前包以及子包下
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        return new RandomRule();//随机
    }
}
