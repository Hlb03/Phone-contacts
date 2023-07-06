package com.example.phonecontacts.controller;

import com.example.phonecontacts.convertion.ContactConvert;
import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.entity.Contact;
import com.example.phonecontacts.service.ContactService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;
    private final ContactConvert contactConvert;

    public ContactController(ContactService contactService, ContactConvert contactConvert) {
        this.contactService = contactService;
        this.contactConvert = contactConvert;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addContact(@RequestBody ContactDTO contactDTO) {
        System.out.println("INPUT: " + contactDTO);
        Contact contact = contactConvert.convertDTO(contactDTO);
        System.out.println("OUTPUT: " + contact);

        contactService.addNewContact(contact);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactDTO> getAllContacts() {
        return contactService.getAllContacts()
                .stream()
                .map(contactConvert::convertEntity)
                .collect(Collectors.toList());
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateContact(@PathVariable int userId, @RequestBody ContactDTO contactDTO) {
        System.out.println("CONTACT DTO: " + contactDTO);
        contactService.updateContactInfo(userId ,contactConvert.convertDTO(contactDTO));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable int userId) {
        contactService.deleteContactById(userId);
    }

    @DeleteMapping("/name/{userName}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteUserByName(@PathVariable String userName) {
        contactService.deleteContactByName(userName);
    }
}
