package com.zz.springcloud.service;

import com.zz.springcloud.entities.CommonResult;
import com.zz.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 业务逻辑接口 + @FeignClient 调用 provider 服务
 * 创建Feign组件使用的接口
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymenService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
