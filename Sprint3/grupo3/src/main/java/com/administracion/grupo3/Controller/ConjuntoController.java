
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.Conjunto;
import com.administracion.grupo3.Service.ConjuntoService;
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
@RequestMapping("/conjunto")
public class ConjuntoController {
    @Autowired
    private ConjuntoService conjuntoService;
    
    @PostMapping(value="/")
    public ResponseEntity<Conjunto>agregar(@RequestBody Conjunto conjunto){
        Conjunto obj = conjuntoService.save(conjunto);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<Conjunto>eliminar(@PathVariable Integer id){
    Conjunto obj= conjuntoService.findById(id);
    if(obj!=null)
             conjuntoService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Conjunto>editar(@RequestBody Conjunto conjunto){
    Conjunto obj= conjuntoService.findById(conjunto.getConjunto_id());
    if(obj!=null){        
        obj.setConjunto_name(conjunto.getConjunto_name());
        conjuntoService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Conjunto>consultarTodo(){
        return conjuntoService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public Conjunto consultarPorId(@PathVariable Integer id){
        return conjuntoService.findById(id);
    }  
    
}

