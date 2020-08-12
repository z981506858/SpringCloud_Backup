package com.zz.springcloud.service.imp;

import com.zz.springcloud.dao.PaymentDao;
import com.zz.springcloud.entities.Payment;
import com.zz.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentImp implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
