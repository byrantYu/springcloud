package com.atguigu.springcloud.alibaba.service;


/**
 * @author 93497
 */
public interface StorageService {
    /**
     * 扣减库存
     *
     */
    void decrease(Long productId, Integer count);
}
