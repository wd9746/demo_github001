package com.dt.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Feign 日志配置
 * @Author: WD
 * @Date: 2020/5/30 10:34
 */
@Configuration
public class FeignLoggerConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
