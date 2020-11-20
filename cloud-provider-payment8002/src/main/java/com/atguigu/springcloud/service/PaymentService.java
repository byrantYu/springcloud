package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 93497
 */
public interface PaymentService {

    /**
     * 写操作
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 读操作
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id")Long id);

}
