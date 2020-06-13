package com.dt.springcloud.service;

import com.dt.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentFeignService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/29 21:35
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    // 测试feign超时机制
    @GetMapping("/payment/timeout")
    public String testFeignTimeout();
}
