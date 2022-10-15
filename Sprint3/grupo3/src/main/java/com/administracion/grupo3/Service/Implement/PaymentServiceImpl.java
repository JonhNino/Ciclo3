
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.PaymentService;
import com.administracion.grupo3.Dao.PaymentDao;
import com.administracion.grupo3.Models.Payment;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentDao paymentDao;
    
    @Override
    @Transactional(readOnly = false)
    public Payment save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer payment_id) {
        paymentDao.deleteById(payment_id);
    }

    @Override
        @Transactional(readOnly = true)
    public Payment findById(Integer payment_id) {
        return paymentDao.findById(payment_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Payment> findByAll() {
        return (List<Payment>) paymentDao.findAll();
    }
        
}