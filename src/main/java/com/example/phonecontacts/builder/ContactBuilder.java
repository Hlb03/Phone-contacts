package com.example.phonecontacts.builder;

import com.example.phonecontacts.entity.Contact;
import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;
import com.example.phonecontacts.entity.User;

import java.util.List;

public interface ContactBuilder {

    ContactBuilder setId(int id);
    ContactBuilder setName(String name);
    ContactBuilder setEmails(List<Email> emails);
    ContactBuilder setPhones(List<PhoneNumber> numbers);

    ContactBuilder setUser(User user);

    Contact build();
}
