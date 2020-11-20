package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 93497
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @LoadBalanced 开启负载均衡（轮询）
     * @return
     */
    @Bean
    /**@LoadBalanced*/
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
