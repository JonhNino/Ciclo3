package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.Document_type;
import java.util.List;

public interface Document_typeService {
    public Document_type save (Document_type document_type);
    public void delete (Integer document_type_id);
    public Document_type findById(Integer document_type_id);
    public List <Document_type>findByAll();
}

