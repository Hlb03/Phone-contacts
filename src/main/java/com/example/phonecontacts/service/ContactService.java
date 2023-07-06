package com.example.phonecontacts.service;

import com.example.phonecontacts.entity.Contact;

import java.util.List;

public interface ContactService {

    void addNewContact(Contact contact, String userName);

    List<Contact> getAllContacts(String username);

    void updateContactInfo(int contactId, Contact contact);

    void deleteContactById(int id);
    void deleteContactByName(String name);
}
