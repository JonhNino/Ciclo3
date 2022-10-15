
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.User_roleService;
import com.administracion.grupo3.Dao.User_roleDao;
import com.administracion.grupo3.Models.User_role;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User_roleServiceImpl implements User_roleService{

    @Autowired
    private User_roleDao user_roleDao;
    
    @Override
    @Transactional(readOnly = false)
    public User_role save(User_role user_role) {
        return user_roleDao.save(user_role);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer user_role_id) {
        user_roleDao.deleteById(user_role_id);
    }

    @Override
        @Transactional(readOnly = true)
    public User_role findById(Integer user_role_id) {
        return user_roleDao.findById(user_role_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User_role> findByAll() {
        return (List<User_role>) user_roleDao.findAll();
    }
        
}