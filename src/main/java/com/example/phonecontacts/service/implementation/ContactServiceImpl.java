package com.example.phonecontacts.service.implementation;

import com.example.phonecontacts.builder.ContactBuilder;
import com.example.phonecontacts.entity.Contact;
import com.example.phonecontacts.repository.ContactRepository;
import com.example.phonecontacts.repository.UserRepository;
import com.example.phonecontacts.service.ContactService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    private final ContactBuilder contactBuilder;

    public ContactServiceImpl(ContactRepository contactRepository, UserRepository userRepository, ContactBuilder builder) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
        this.contactBuilder = builder;
    }


    @Override
    @Transactional
    public void addNewContact(Contact contact, String username) {
        System.out.println(username);
        contact.setUser(
                userRepository.getUserByUserName(username).get()
        );
        contact.setId(0);
        contactRepository.save(contact);

        contact.getEmails()
                .forEach(
                        email -> {
                            email.setContact(contactBuilder.setId(contact.getId()).build());
                            email.setId(0);
                        }
                );
        contact.getPhoneNumbers()
                .forEach(
                        number -> {
                            number.setContact(contactBuilder.setId(contact.getId()).build());
                            number.setId(0);
                        }
                );

        contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts(String username) {
        return contactRepository.findAllByUserUserName(username);
    }

    @Override
    public void updateContactInfo(int contactId, Contact contact) {
        Contact cont = contactRepository.findById(contactId).orElseThrow(EntityNotFoundException::new);
        cont.setName(contact.getName());
        cont.setEmails(contact.getEmails());
        cont.setPhoneNumbers(contact.getPhoneNumbers());

        cont.getEmails()
                .forEach(
                        email -> email.setContact(contactBuilder.setId(contactId).build())
                );
        cont.getPhoneNumbers()
                .forEach(
                        number -> number.setContact(contactBuilder.setId(contactId).build())
                );

        System.out.println(cont);
        contactRepository.save(cont);
    }

    @Override
    public void deleteContactById(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteContactByName(String name) {
        contactRepository.deleteByName(name);
    }
}
