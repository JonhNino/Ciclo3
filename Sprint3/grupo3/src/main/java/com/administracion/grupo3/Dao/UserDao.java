package com.administracion.grupo3.Dao;
import com.administracion.grupo3.Models.User;
import org.springframework.data.repository.CrudRepository;
public interface UserDao  extends CrudRepository<User, Integer>{
        
}
