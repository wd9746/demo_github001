package com.dt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ProjectName: springcloud2020
 * @ClassName: GatewayCullMain9527
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/3 11:01
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayCullMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayCullMain9527.class,args);
    }
}
