package com.dt.springcloud.service;

import com.dt.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/27 16:24
 */
public interface PaymentService {

    public int crate(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
