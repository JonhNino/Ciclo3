
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
@Entity(name="role")
public class Role implements Serializable{
    
    @Id
    @Column(name="role_id")
    private int role_id;
    @Column(name="role_name")
    private String role_name;
    @Column(name="role_active")
    private String role_active;
    @Column(name="role_created_at")
    private String role_created_at;

    public Role(int role_id, String role_name, String role_active, String role_created_at) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_active = role_active;
        this.role_created_at = role_created_at;
    }

    public Role() {
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_active() {
        return role_active;
    }

    public void setRole_active(String role_active) {
        this.role_active = role_active;
    }

    public String getRole_created_at() {
        return role_created_at;
    }

    public void setRole_created_at(String role_created_at) {
        this.role_created_at = role_created_at;
    }
    
    
}
