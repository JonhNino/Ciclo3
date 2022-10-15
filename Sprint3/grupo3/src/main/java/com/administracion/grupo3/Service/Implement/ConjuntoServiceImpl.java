
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.ConjuntoService;
import com.administracion.grupo3.Dao.ConjuntoDao;
import com.administracion.grupo3.Models.Conjunto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConjuntoServiceImpl implements ConjuntoService{

    @Autowired
    private ConjuntoDao conjuntoDao;
    
    @Override
    @Transactional(readOnly = false)
    public Conjunto save(Conjunto conjunto) {
        return conjuntoDao.save(conjunto);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer conjunto_id) {
        conjuntoDao.deleteById(conjunto_id);
    }

    @Override
        @Transactional(readOnly = true)
    public Conjunto findById(Integer conjunto_id) {
        return conjuntoDao.findById(conjunto_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Conjunto> findByAll() {
        return (List<Conjunto>) conjuntoDao.findAll();
    }
        
}