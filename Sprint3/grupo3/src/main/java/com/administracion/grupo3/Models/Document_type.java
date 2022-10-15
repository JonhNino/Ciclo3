
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
@Entity(name="Document_type")
public class Document_type implements Serializable{
    
    @Id
    @Column(name="document_type_id")
    private int document_type_id;
    @Column(name="document_type_name")
    private String document_type_name;
    @Column(name="document_type_active")
    private String document_type_active;
    @Column(name="created_at")
    private String created_at;

    public Document_type(int document_type_id, String document_type_name, String document_type_active, String created_at) {
        this.document_type_id = document_type_id;
        this.document_type_name = document_type_name;
        this.document_type_active = document_type_active;
        this.created_at = created_at;
    }

    public Document_type() {
    }

    public int getDocument_type_id() {
        return document_type_id;
    }

    public void setDocument_type_id(int document_type_id) {
        this.document_type_id = document_type_id;
    }

    public String getDocument_type_name() {
        return document_type_name;
    }

    public void setDocument_type_name(String document_type_name) {
        this.document_type_name = document_type_name;
    }

    public String getDocument_type_active() {
        return document_type_active;
    }

    public void setDocument_type_active(String document_type_active) {
        this.document_type_active = document_type_active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
}
