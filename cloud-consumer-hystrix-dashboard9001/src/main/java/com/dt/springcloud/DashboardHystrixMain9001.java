package com.dt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ProjectName: springcloud2020
 * @ClassName: DashboardHystrixMain9001
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/3 8:53
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardHystrixMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(DashboardHystrixMain9001.class,args);
    }
}
