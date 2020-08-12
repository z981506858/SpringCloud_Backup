package com.zz.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 完成服务端之间的通信
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced //赋予负载均衡能力
    public RestTemplate getRestTemplate() {
        return  new RestTemplate();
    }
}
