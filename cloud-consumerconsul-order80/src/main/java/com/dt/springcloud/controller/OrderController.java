package com.dt.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: springcloud2020
 * @ClassName: OrderController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/29 8:51
 */
@RestController
public class OrderController {

    private final static String INVOKE_URL="http://cloud-providerconsul-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String payment(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}
