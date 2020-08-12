package com.zz.springcloud.service;


import com.zz.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getById(Long id);
}
