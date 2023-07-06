package com.example.phonecontacts.builder.impls;

import com.example.phonecontacts.builder.ContactBuilder;
import com.example.phonecontacts.entity.Contact;
import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;
import com.example.phonecontacts.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactBuilderImpl implements ContactBuilder {

    private final Contact contact;

    public ContactBuilderImpl() {
        this.contact = new Contact();
    }


    @Override
    public ContactBuilder setId(int id) {
        contact.setId(id);
        return this;
    }

    @Override
    public ContactBuilder setName(String name) {
        contact.setName(name);
        return this;
    }

    @Override
    public ContactBuilder setEmails(List<Email> emails) {
        contact.setEmails(emails);
        return this;
    }

    @Override
    public ContactBuilder setPhones(List<PhoneNumber> numbers) {
        contact.setPhoneNumbers(numbers);
        return this;
    }

    @Override
    public ContactBuilder setUser(User user) {
        contact.setUser(user);
        return this;
    }

    @Override
    public Contact build() {
        return contact;
    }

}
