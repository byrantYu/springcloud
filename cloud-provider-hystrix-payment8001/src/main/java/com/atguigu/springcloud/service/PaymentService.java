package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author 93497
 */
@Service
public class PaymentService {


    public String paymentInfo_ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() +
                "paymentInfo_ok,id: " + id + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(Integer id){
        /**int i = 10/0;*/
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() +
                "paymentInfo_timeout,id: " + id + "O(∩_∩)O哈哈~"
                + "耗时"+timeNumber+"秒钟";
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() +
                "8001系统繁忙或者运行出错，请稍后再试,id: " + id + "\t" + "o(╥﹏╥)o";
    }

    /**
     * 服务熔断
     * circuitBreaker.enabled 是否开启断路器
     * circuitBreaker.requestVolumeThreshold 请求次数
     * sleepWindowInMilliseconds 时间窗口期
     * circuitBreaker.errorThresholdPercentage 失败率达到多少后跳闸
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" +
                serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id不能负数，请稍后再试。id: " + id;
    }

}
