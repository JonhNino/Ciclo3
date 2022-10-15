
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.User;
import com.administracion.grupo3.Service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping(value="/")
    public ResponseEntity<User>agregar(@RequestBody User user){
        User obj = userService.save(user);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<User>eliminar(@PathVariable Integer id){
    User obj= userService.findById(id);
    if(obj!=null)
             userService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<User>editar(@RequestBody User user){
    User obj= userService.findById(user.getUser_id());
    if(obj!=null){        
        obj.setUser_name(user.getUser_name());
        obj.setUser_password(user.getUser_password());
        obj.setUser_active(user.getUser_active());
        userService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<User>consultarTodo(){
        return userService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public User consultarPorId(@PathVariable Integer id){
        return userService.findById(id);
    }  
    
}

