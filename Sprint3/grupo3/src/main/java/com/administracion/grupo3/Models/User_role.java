
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
@Entity(name="user_role")
public class User_role implements Serializable{
    
    @Id
    @Column(name="user_role_id")    
    private int user_role_id;
    
    @ManyToOne
    @JoinColumn(name="user_user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="role_role_id")
    private Role role; 


    public User_role() {
    }

    public User_role(int user_role_id, User user,Role role) {
        this.user_role_id = user_role_id;
        this.user = user;
        this.role=role;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    
    
}
