package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.Apartamento;
import java.util.List;

public interface ApartamentoService {
    public Apartamento save (Apartamento apartamento);
    public void delete (Integer apartamento_id);
    public Apartamento findById(Integer apartamento_id);
    public List <Apartamento>findByAll();
}
