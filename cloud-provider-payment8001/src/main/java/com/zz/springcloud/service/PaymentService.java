package com.zz.springcloud.service;


import com.zz.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getById(Long id);
}
