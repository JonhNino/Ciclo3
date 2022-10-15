package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.Role;
import java.util.List;

public interface RoleService {
    public Role save (Role role);
    public void delete (Integer role_id);
    public Role findById(Integer role_id);
    public List <Role>findByAll();
}
