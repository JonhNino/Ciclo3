
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.UserService;
import com.administracion.grupo3.Dao.UserDao;
import com.administracion.grupo3.Models.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Override
    @Transactional(readOnly = false)
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer user_id) {
        userDao.deleteById(user_id);
    }

    @Override
        @Transactional(readOnly = true)
    public User findById(Integer user_id) {
        return userDao.findById(user_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByAll() {
        return (List<User>) userDao.findAll();
    }
        
}