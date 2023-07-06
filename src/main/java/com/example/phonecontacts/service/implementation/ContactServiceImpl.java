package com.example.phonecontacts.service.implementation;

import com.example.phonecontacts.builder.ContactBuilder;
import com.example.phonecontacts.entity.Contact;
import com.example.phonecontacts.entity.User;
import com.example.phonecontacts.repository.ContactRepository;
import com.example.phonecontacts.repository.EmailRepository;
import com.example.phonecontacts.repository.PhoneNumberRepository;
import com.example.phonecontacts.service.ContactService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final EmailRepository emailRepository;
    private final PhoneNumberRepository numberRepository;
    private final ContactBuilder contactBuilder;

    public ContactServiceImpl(ContactRepository contactRepository, EmailRepository emailRepository, PhoneNumberRepository numberRepository, ContactBuilder builder) {
        this.contactRepository = contactRepository;
        this.emailRepository = emailRepository;
        this.numberRepository = numberRepository;
        this.contactBuilder = builder;
    }


    // TODO: extract user identifier from Spring Security session credentials
    @Override
    @Transactional
    public void addNewContact(Contact contact) {
        User user = new User();
        user.setId(1);
        contact.setUser(user);
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
    public List<Contact> getAllContacts() {
        return contactRepository.findAllByUserId(1);
    }

    @Override
    public void updateContactInfo(int userId, Contact contact) {
        Contact cont = contactRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        cont.setName(contact.getName());
        cont.setEmails(contact.getEmails());
        cont.setPhoneNumbers(contact.getPhoneNumbers());

        contact.getEmails()
                .forEach(
                        email -> email.setContact(contactBuilder.setId(userId).build())
                );
        contact.getPhoneNumbers()
                .forEach(
                        number -> number.setContact(contactBuilder.setId(userId).build())
                );

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
