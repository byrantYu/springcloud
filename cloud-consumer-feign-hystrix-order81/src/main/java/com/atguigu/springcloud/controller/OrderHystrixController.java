package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 93497
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        String result = orderHystrixService.paymentInfo_ok(id);
        return result;
    }

    /**@HystrixCommand(fallbackMethod = "paymentInfo_timeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id")Integer id){
        String result = orderHystrixService.paymentInfo_timeout(id);
        return result;
    }

    public String paymentInfo_timeoutFallbackMethod(@PathVariable("id")Integer id){
       return "我是消费者81，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，o(╥﹏╥)o";
    }

    /**
     *
     */
    public String payment_Global_fallbackMethod(){
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }
}
