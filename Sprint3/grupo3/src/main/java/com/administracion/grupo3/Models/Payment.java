
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
@Entity(name="payment")
public class Payment implements Serializable{
    
    @Id
    @Column(name="payment_id")
    private int payment_id;
    @Column(name="payment_reference")
    private String payment_reference;
    @Column(name="payment_person_name")
    private String payment_person_name;
    @Column(name="payment_person_email")
    private String payment_person_email;
    @Column(name="payment_status")
    private String payment_status;
    @Column(name="created_at")
    private String created_at;
    @ManyToOne
    @JoinColumn(name="apartamento_apartamento_id")
    private  Apartamento apartamento;

    public Payment(int payment_id, String payment_reference, String payment_person_name, String payment_person_email, String payment_status, String created_at, Apartamento apartamento) {
        this.payment_id = payment_id;
        this.payment_reference = payment_reference;
        this.payment_person_name = payment_person_name;
        this.payment_person_email = payment_person_email;
        this.payment_status = payment_status;
        this.created_at = created_at;
        this.apartamento = apartamento;
    }

    public Payment() {
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_reference() {
        return payment_reference;
    }

    public void setPayment_reference(String payment_reference) {
        this.payment_reference = payment_reference;
    }

    public String getPayment_person_name() {
        return payment_person_name;
    }

    public void setPayment_person_name(String payment_person_name) {
        this.payment_person_name = payment_person_name;
    }

    public String getPayment_person_email() {
        return payment_person_email;
    }

    public void setPayment_person_email(String payment_person_email) {
        this.payment_person_email = payment_person_email;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }
    
    
}
