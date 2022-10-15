
package com.administracion.grupo3.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Table
@Entity(name="Conjunto")
public class Conjunto {
    
    @Id
    @Column(name="conjunto_id")
    private int conjunto_id;
    @Column(name="conjunto_name")
    private String conjunto_name;
    @ManyToOne
    @JoinColumn(name="apartamento_apartamento_id")
    private Apartamento apartamento;

    public Conjunto(int conjunto_id, String conjunto_name, Apartamento apartamento) {
        this.conjunto_id = conjunto_id;
        this.conjunto_name = conjunto_name;
        this.apartamento = apartamento;
    }
    public Conjunto() {
    }

    public int getConjunto_id() {
        return conjunto_id;
    }

    public void setConjunto_id(int conjunto_id) {
        this.conjunto_id = conjunto_id;
    }

    public String getConjunto_name() {
        return conjunto_name;
    }

    public void setConjunto_name(String conjunto_name) {
        this.conjunto_name = conjunto_name;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }
   
    
}
