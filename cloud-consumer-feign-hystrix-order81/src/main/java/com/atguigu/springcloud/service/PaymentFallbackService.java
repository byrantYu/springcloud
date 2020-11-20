package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 93497
 */
@Component
public class PaymentFallbackService implements OrderHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "---------PaymentFallbackService fall back paymentInfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "---------PaymentFallbackService fall back paymentInfo_timeout";
    }
}
