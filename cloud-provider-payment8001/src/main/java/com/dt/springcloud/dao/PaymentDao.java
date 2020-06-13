package com.dt.springcloud.dao;

import com.dt.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: springcloud2020
 * @ClassName: PaymentDao
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/5/27 16:04
 */
@Mapper
public interface PaymentDao {

    public int crate(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
