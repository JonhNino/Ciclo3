
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.Payment;
import com.administracion.grupo3.Service.PaymentService;
import java.util.List;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    
    @PostMapping(value="/")
    public ResponseEntity<Payment>agregar(@RequestBody Payment payment){
        Payment obj = paymentService.save(payment);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<Payment>eliminar(@PathVariable Integer id){
    Payment obj= paymentService.findById(id);
    if(obj!=null)
             paymentService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Payment>editar(@RequestBody Payment payment){
    Payment obj= paymentService.findById(payment.getPayment_id());
    if(obj!=null){        
        obj.setPayment_reference(payment.getPayment_reference());
        obj.setPayment_person_name(payment.getPayment_person_name());
        obj.setPayment_person_email(payment.getPayment_person_email());
        obj.setPayment_status(payment.getPayment_status());
        paymentService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Payment>consultarTodo(){
        return paymentService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public Payment consultarPorId(@PathVariable Integer id){
        return paymentService.findById(id);
    }  
    
}

