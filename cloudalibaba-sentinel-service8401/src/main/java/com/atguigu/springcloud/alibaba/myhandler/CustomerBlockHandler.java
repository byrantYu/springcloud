package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author 93497
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException blockException){
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }

}
