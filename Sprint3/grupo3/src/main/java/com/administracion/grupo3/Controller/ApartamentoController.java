
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.Apartamento;
import com.administracion.grupo3.Service.ApartamentoService;
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
@RequestMapping("/apartamento")
public class ApartamentoController {
    @Autowired
    private ApartamentoService apartamentoService;
    
    @PostMapping(value="/")
    public ResponseEntity<Apartamento>agregar(@RequestBody Apartamento apartamento){
        Apartamento obj = apartamentoService.save(apartamento);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<Apartamento>eliminar(@PathVariable Integer id){
    Apartamento obj= apartamentoService.findById(id);
    if(obj!=null)
             apartamentoService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Apartamento>editar(@RequestBody Apartamento apartamento){
    Apartamento obj= apartamentoService.findById(apartamento.getApartamento_id());
    if(obj!=null){
        obj.setApartamento(apartamento.getApartamento());
        obj.setApartamento_name(apartamento.getApartamento_name());
        apartamentoService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Apartamento>consultarTodo(){
        return apartamentoService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public Apartamento consultarPorId(@PathVariable Integer id){
        return apartamentoService.findById(id);
    }  
    
}

