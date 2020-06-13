package com.dt.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/28 11:50
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public Object payment(){
        return "Spring with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
