package com.zz.springcloud.controller;

import com.zz.springcloud.entities.CommonResult;
import com.zz.springcloud.entities.Payment;
import com.zz.springcloud.service.PaymenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    PaymenService paymenService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        return paymenService.getById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymenService.paymentFeignTimeout();
    }
}
