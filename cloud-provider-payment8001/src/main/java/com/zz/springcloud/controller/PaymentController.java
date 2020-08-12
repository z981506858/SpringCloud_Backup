package com.zz.springcloud.controller;

import com.zz.springcloud.entities.CommonResult;
import com.zz.springcloud.entities.Payment;
import com.zz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String servicePort;

    /**
     * 往数据库插数据
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult createpay(@RequestBody Payment payment){
        int code = paymentService.create(payment);
        log.info("******插入结果："+code);
        if (code > 0){
            return new CommonResult(200,"插入成功,执行端口："+servicePort,code);
        } else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        log.info("******插入结果："+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,执行端口："+servicePort,payment);
        } else {
            return new CommonResult(444,"查询失败，对应ID="+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            log.info("*********** Element:"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb(){
        return servicePort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servicePort;
    }
}
