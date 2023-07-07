package com.example.phonecontacts.builder;

import com.example.phonecontacts.entity.Contact;
import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;
import com.example.phonecontacts.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactBuilder {
    private Contact contact;

    public ContactBuilder() {}


    public ContactBuilder builder() {
        contact = new Contact();
        return this;
    }

    public ContactBuilder setId(int id) {
        contact.setId(id);
        return this;
    }

    public ContactBuilder setName(String name) {
        contact.setName(name);
        return this;
    }

    public ContactBuilder setEmails(List<Email> emails) {
        contact.setEmails(emails);
        return this;
    }

    public ContactBuilder setPhones(List<PhoneNumber> numbers) {
        contact.setPhoneNumbers(numbers);
        return this;
    }

    public ContactBuilder setUser(User user) {
        contact.setUser(user);
        return this;
    }

    public Contact build() {
        return contact;
    }

}
