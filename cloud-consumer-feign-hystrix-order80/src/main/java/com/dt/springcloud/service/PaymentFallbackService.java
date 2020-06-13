package com.dt.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description: 此实现类统一处理异常，可以解决代码的耦合度问题
 * @Author: WD
 * @Date: 2020/6/1 16:41
 */
@Component
public class PaymentFallbackService implements OrderHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "PaymentFallbackService fallback payment_ok ,访问超时或出现错误";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "PaymentFallbackService fallback payment_timeout ，访问超时或出现错误";
    }
}
