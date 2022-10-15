package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.Conjunto;
import java.util.List;

public interface ConjuntoService {
    public Conjunto save (Conjunto conjunto);
    public void delete (Integer conjunto_id);
    public Conjunto findById(Integer conjunto_id);
    public List <Conjunto>findByAll();
}
