
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.User_role;
import com.administracion.grupo3.Service.User_roleService;
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
@RequestMapping("/user_role")
public class User_roleController {
    @Autowired
    private User_roleService user_roleService;
    
    @PostMapping(value="/")
    public ResponseEntity<User_role>agregar(@RequestBody User_role user_role){
        User_role obj = user_roleService.save(user_role);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<User_role>eliminar(@PathVariable Integer id){
    User_role obj= user_roleService.findById(id);
    if(obj!=null)
             user_roleService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<User_role>editar(@RequestBody User_role user_role){
    User_role obj= user_roleService.findById(user_role.getUser_role_id());
    if(obj!=null){                
        obj.setUser(user_role.getUser());
        obj.setRole(user_role.getRole());
        user_roleService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<User_role>consultarTodo(){
        return user_roleService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public User_role consultarPorId(@PathVariable Integer id){
        return user_roleService.findById(id);
    }  
    
}

