
package com.administracion.grupo3.Service.Implement;

import com.administracion.grupo3.Service.PersonService;
import com.administracion.grupo3.Dao.PersonDao;
import com.administracion.grupo3.Models.Person;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDao personDao;
    
    @Override
    @Transactional(readOnly = false)
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
        @Transactional(readOnly = false)
    public void delete(Integer person_id) {
        personDao.deleteById(person_id);
    }

    @Override
        @Transactional(readOnly = true)
    public Person findById(Integer person_id) {
        return personDao.findById(person_id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findByAll() {
        return (List<Person>) personDao.findAll();
    }
        
}