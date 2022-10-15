
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.Document_typeService;
import com.administracion.grupo3.Dao.Document_typeDao;
import com.administracion.grupo3.Models.Document_type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Document_typeServiceImpl implements Document_typeService{

    @Autowired
    private Document_typeDao document_typeDao;
    
    @Override
    @Transactional(readOnly = false)
    public Document_type save(Document_type document_type) {
        return document_typeDao.save(document_type);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer document_type_id) {
        document_typeDao.deleteById(document_type_id);
    }

    @Override
        @Transactional(readOnly = true)
    public Document_type findById(Integer document_type_id) {
        return document_typeDao.findById(document_type_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Document_type> findByAll() {
        return (List<Document_type>) document_typeDao.findAll();
    }
        
}