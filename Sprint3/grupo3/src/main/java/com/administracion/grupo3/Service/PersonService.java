package com.administracion.grupo3.Service;
import com.administracion.grupo3.Models.Person;
import java.util.List;

public interface PersonService {
    public Person save (Person person);
    public void delete (Integer person_id);
    public Person findById(Integer person_id);
    public List <Person>findByAll();
}
