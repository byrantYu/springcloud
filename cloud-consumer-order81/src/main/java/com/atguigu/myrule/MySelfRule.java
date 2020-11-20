package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 93497
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        /**
         * 定义为随机负载算法
         */
        return new RandomRule();
    }
}
