package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 93497
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain81.class,args);
    }
}
