
package com.administracion.grupo3.Controller;

import com.administracion.grupo3.Models.Role;
import com.administracion.grupo3.Service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    
    @PostMapping(value="/")
    public ResponseEntity<Role>agregar(@RequestBody Role role){
        Role obj = roleService.save(role);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @DeleteMapping(value="/(id)")
    public ResponseEntity<Role>eliminar(@PathVariable Integer id){
    Role obj= roleService.findById(id);
    if(obj!=null)
             roleService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    
    return new ResponseEntity<>(obj,HttpStatus.OK);       
    }
    
    @PutMapping(value="/")
    public ResponseEntity<Role>editar(@RequestBody Role role){
    Role obj= roleService.findById(role.getRole_id());
    if(obj!=null){        
        obj.setRole_name(role.getRole_name());
        obj.setRole_active(role.getRole_active());
        roleService.save(obj);
    }    
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Role>consultarTodo(){
        return roleService.findByAll();
    }
    
     @GetMapping("/list/{id}")
    public Role consultarPorId(@PathVariable Integer id){
        return roleService.findById(id);
    }  
    
}

