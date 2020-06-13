package com.dt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ProjectName: springcloud2020
 * @ClassName: CenterConfigMain3344
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/5 9:38
 */
@SpringBootApplication
@EnableConfigServer
public class CenterConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(CenterConfigMain3344.class,args);
    }
}
