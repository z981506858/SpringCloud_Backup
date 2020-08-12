package com.zz.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon
 * 修改Ribbon的均衡方式
 *      由轮询改为随机
 */
@Configuration
public class MySelRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//随机
    }
}
