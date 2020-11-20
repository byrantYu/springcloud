package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 93497
 */
@Mapper
public interface PaymentDao {

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
