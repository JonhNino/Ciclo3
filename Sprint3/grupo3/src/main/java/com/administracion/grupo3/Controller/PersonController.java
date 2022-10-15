
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.Person;
import com.administracion.grupo3.Service.PersonService;
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
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    
    @PostMapping(value="/")
    public ResponseEntity<Person>agregar(@RequestBody Person person){
        Person obj = personService.save(person);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<Person>eliminar(@PathVariable Integer id){
    Person obj= personService.findById(id);
    if(obj!=null)
             personService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Person>editar(@RequestBody Person person){
    Person obj= personService.findById(person.getPerson_id());
    if(obj!=null){        
        obj.setPerson_name(person.getPerson_name());
        obj.setPerson_lastname(person.getPerson_lastname());
        obj.setPerson_document_number(person.getPerson_document_number());
        obj.setPerson_phone(person.getPerson_phone());
        obj.setPerson_email(person.getPerson_email());
        personService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Person>consultarTodo(){
        return personService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public Person consultarPorId(@PathVariable Integer id){
        return personService.findById(id);
    }  
    
}

