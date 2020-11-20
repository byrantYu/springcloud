package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 93497
 *
 * @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
 * 使用自定义的负载算法
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class,args);
    }
}
