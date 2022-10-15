
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
@Entity(name="user")
public class User implements Serializable{
    
    @Id
    @Column(name="user_id")
    private int user_id;
    @Column(name="user_name")
    private String user_name;
    @Column(name="user_password")
    private String user_password;
    @Column(name="user_active")
    private String user_active;
    @Column(name="user_created_at")
    private String user_created_at;
    @ManyToOne
    @JoinColumn(name="apartamento_apartamento_id")
    private Apartamento apartamento;
    

    public User(int user_id, String user_name, String user_password, String user_active, String user_created_at, Apartamento apartamento) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_active = user_active;
        this.user_created_at = user_created_at;
        this.apartamento =apartamento;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_active() {
        return user_active;
    }

    public void setUser_active(String user_active) {
        this.user_active = user_active;
    }

    public String getUser_created_at() {
        return user_created_at;
    }

    public void setUser_created_at(String user_created_at) {
        this.user_created_at = user_created_at;
    }
    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

 
    
    
}
