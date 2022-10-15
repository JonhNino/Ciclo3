
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.ApartamentoService;
import com.administracion.grupo3.Dao.ApartamentoDao;
import com.administracion.grupo3.Models.Apartamento;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartamentoServiceImpl implements ApartamentoService{

    @Autowired
    private ApartamentoDao apartamentoDao;
    
    @Override
    @Transactional(readOnly = false)
    public Apartamento save(Apartamento apartamento) {
        return apartamentoDao.save(apartamento);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer apartamento_id) {
        apartamentoDao.deleteById(apartamento_id);
    }

    @Override
        @Transactional(readOnly = true)
    public Apartamento findById(Integer apartamento_id) {
        return apartamentoDao.findById(apartamento_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Apartamento> findByAll() {
        return (List<Apartamento>) apartamentoDao.findAll();
    }
        
}
