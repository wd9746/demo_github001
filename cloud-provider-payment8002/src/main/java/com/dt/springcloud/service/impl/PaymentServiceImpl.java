package com.dt.springcloud.service.impl;

import com.dt.springcloud.dao.PaymentDao;
import com.dt.springcloud.entities.Payment;
import com.dt.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentServiceImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/27 16:24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int crate(Payment payment) {
        return paymentDao.crate(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
