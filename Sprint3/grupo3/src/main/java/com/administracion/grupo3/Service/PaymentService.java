package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.Payment;
import java.util.List;

public interface PaymentService {
    public Payment save (Payment payment);
    public void delete (Integer payment_id);
    public Payment findById(Integer payment_id);
    public List <Payment>findByAll();
}