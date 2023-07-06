package com.example.phonecontacts.service;

import com.example.phonecontacts.entity.Contact;

import java.util.List;

public interface ContactService {

    void addNewContact(Contact contact);

    List<Contact> getAllContacts();

    void updateContactInfo(int userId, Contact contact);

    void deleteContactById(int id);
    void deleteContactByName(String name);
}
