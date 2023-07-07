package com.example.phonecontacts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "email")
public class Email implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @jakarta.validation.constraints.Email(message = "Incorrect email provided")
    private String mail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    private Contact contact;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id == email.id && Objects.equals(mail, email.mail) && Objects.equals(contact, email.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, contact);
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
//                ", contact=" + contact.getId() +
                '}';
    }
}
