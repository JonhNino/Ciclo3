
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.Document_type;
import com.administracion.grupo3.Service.Document_typeService;
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
@RequestMapping("/document_type")
public class Document_typeController {
    @Autowired
    private Document_typeService document_typeService;
    
    @PostMapping(value="/")
    public ResponseEntity<Document_type>agregar(@RequestBody Document_type document_type){
        Document_type obj = document_typeService.save(document_type);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<Document_type>eliminar(@PathVariable Integer id){
    Document_type obj= document_typeService.findById(id);
    if(obj!=null)
             document_typeService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Document_type>editar(@RequestBody Document_type document_type){
    Document_type obj= document_typeService.findById(document_type.getDocument_type_id());
    if(obj!=null){        
        obj.setDocument_type_name(document_type.getDocument_type_name());
        obj.setDocument_type_active(document_type.getDocument_type_active());
        document_typeService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Document_type>consultarTodo(){
        return document_typeService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public Document_type consultarPorId(@PathVariable Integer id){
        return document_typeService.findById(id);
    }  
    
}

