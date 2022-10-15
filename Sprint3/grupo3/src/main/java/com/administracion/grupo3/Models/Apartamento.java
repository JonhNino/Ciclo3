
package com.administracion.grupo3.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Table
@Entity(name="apartamento")
public class Apartamento implements Serializable{
    @Id
    @Column(name="apartamento_id")
    private int apartamento_id;
     @Column(name="apartamento_name")
    private String apartamento_name;
    @Column(name="apartamento")
     private String apartamento;

    public Apartamento(int apartamento_id, String apartamento_name, String apartamento) {
        this.apartamento_id = apartamento_id;
        this.apartamento_name = apartamento_name;
        this.apartamento = apartamento;
    }

    public Apartamento() {
    }

    public int getApartamento_id() {
        return apartamento_id;
    }

    public void setApartamento_id(int apartamento_id) {
        this.apartamento_id = apartamento_id;
    }

    public String getApartamento_name() {
        return apartamento_name;
    }

    public void setApartamento_name(String apartamento_name) {
        this.apartamento_name = apartamento_name;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }
    
    
}
