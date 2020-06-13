package com.dt.springcloud.controller;

import com.dt.springcloud.entities.CommonResult;
import com.dt.springcloud.entities.Payment;
import com.dt.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/27 16:27
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    /*
           此处需要添加 @RequestBody ，如不添加传入数据库的是null
     */
    @PostMapping(value = "/payment/create")
    public CommonResult crate(@RequestBody Payment payment) {
        int result = paymentService.crate(payment);
        log.info("***插入的结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("***插入的结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询的id：" + id, null);
        }
    }

    @GetMapping("/payment/discover")
    public Object discover() {
        // 获取到所有的注册信息
        List<String> services = discoveryClient.getServices();
        for (String str : services) {
            log.info("****str:" + str);
        }

        //获取指定服务名称的所有注册信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info(serviceInstance.getInstanceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getServerPort() {
        return this.serverPort;
    }

    // 测试feign超时机制
    @GetMapping("/payment/timeout")
    public String testFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    //=========== zipkin + sleuth
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
