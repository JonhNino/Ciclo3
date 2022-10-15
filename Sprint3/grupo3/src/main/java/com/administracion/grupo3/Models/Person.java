
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
@Entity(name="person")
public class Person implements Serializable{
    
    @Id
    @Column(name="person_id")
    private int person_id;
    @Column(name="person_name")
    private String person_name;
    @Column(name="person_lastname")
    private String person_lastname;
    @Column(name="person_document_number")
    private String person_document_number;
    @Column(name="person_phone_number")
    private String person_phone;
    @Column(name="person_email")
    private String person_email;
    @Column(name="person_created_at")
    private String person_created_at;
    
    @ManyToOne
    @JoinColumn(name="user_user_id")
    private  User user;
    
     @ManyToOne
    @JoinColumn(name="document_type_document_type_id")
    private Document_type document_type;

    public Person(int person_id, String person_name, String person_lastname, String person_document_number, String person_phone, String person_email, String person_created_at,  User user, Document_type document_type) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_lastname = person_lastname;
        this.person_document_number = person_document_number;
        this.person_phone= person_phone;
        this.person_email = person_email;
        this.person_created_at = person_created_at;
        this.user = user;
        this.document_type= document_type;
    }

    public Person() {
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_lastname() {
        return person_lastname;
    }

    public void setPerson_lastname(String person_lastname) {
        this.person_lastname = person_lastname;
    }

    public String getPerson_document_number() {
        return person_document_number;
    }

    public void setPerson_document_number(String person_document_number) {
        this.person_document_number = person_document_number;
    }

    public String getPerson_phone() {
        return person_phone;
    }

    public void setPerson_phone(String person_phone) {
        this.person_phone = person_phone;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_created_at() {
        return person_created_at;
    }

    public void setPerson_created_at(String person_created_at) {
        this.person_created_at = person_created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document_type getDocument_type() {
        return document_type;
    }

    public void setDocument_type(Document_type document_type) {
        this.document_type = document_type;
    }


    
}
