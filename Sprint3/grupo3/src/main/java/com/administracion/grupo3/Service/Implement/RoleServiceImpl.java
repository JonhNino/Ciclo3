
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.RoleService;
import com.administracion.grupo3.Dao.RoleDao;
import com.administracion.grupo3.Models.Role;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;
    
    @Override
    @Transactional(readOnly = false)
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer role_id) {
        roleDao.deleteById(role_id);
    }

    @Override
        @Transactional(readOnly = true)
    public Role findById(Integer role_id) {
        return roleDao.findById(role_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findByAll() {
        return (List<Role>) roleDao.findAll();
    }
        
}