package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.User;
import java.util.List;

public interface UserService {
    public User save (User user);
    public void delete (Integer user_id);
    public User findById(Integer user_id);
    public List <User>findByAll();
}
