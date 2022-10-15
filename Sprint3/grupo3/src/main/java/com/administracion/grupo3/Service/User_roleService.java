package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.User_role;
import java.util.List;

public interface User_roleService {
    public User_role save (User_role user_role);
    public void delete (Integer user_role_id);
    public User_role findById(Integer user_role_id);
    public List <User_role>findByAll();
}
