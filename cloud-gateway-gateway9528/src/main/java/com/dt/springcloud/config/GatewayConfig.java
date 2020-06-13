package com.dt.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springcloud2020
 * @ClassName: GatewayConfig
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/3 17:56
 */
@Configuration
public class GatewayConfig {

    /**
     *  配置一个ID为route_name 的路由规则。
     *  当访问地址为 http://localhost:9528/guonei 会自动转换为 http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("route_name",
                        r -> r.path("/guonei")
                                .uri("http://news.baidu.com/guonei")).build();
    }

}
