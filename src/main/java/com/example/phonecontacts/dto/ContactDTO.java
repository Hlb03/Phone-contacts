package com.example.phonecontacts.dto;

import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Component
public class ContactDTO implements Serializable {

    private Integer id;
    private String name;
    private List<Email> emails;
    private List<PhoneNumber> phones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDTO that = (ContactDTO) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(phones, that.phones) && Objects.equals(emails, that.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phones, emails);
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numbers=" + phones +
                ", emails=" + emails +
                '}';
    }
}
