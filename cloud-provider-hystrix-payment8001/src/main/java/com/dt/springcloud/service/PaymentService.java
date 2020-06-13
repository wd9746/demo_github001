package com.dt.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/31 20:50
 */
@Service
public class PaymentService {

    // 表示成功
    public String payment_ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t\t\tpayment_ok：" + id;
    }

    /**
     * 超时访问演示降级
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String payment_timeout(Integer id) {
//        int i=10/0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "\t\t\tpayment_timeout：" + id;
    }

    //兜底方法
    public String payment_timeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\t\t\t我是8001，服务器连接超时，请稍后再试！";
    }

    /***************   服务熔断 ******************************/

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//在允许重试之前断开电路后的毫秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("=>id不能为负数");
        }
        //生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "，调用成功，流水号：" + simpleUUID;
    }

    // 备用方案
    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id不能为负数，请稍后再试。。。id：" + id;
    }
}
