package com.administracion.grupo3.Dao;
import com.administracion.grupo3.Models.Payment;
import org.springframework.data.repository.CrudRepository;
public interface PaymentDao  extends CrudRepository<Payment, Integer>{
        
}
