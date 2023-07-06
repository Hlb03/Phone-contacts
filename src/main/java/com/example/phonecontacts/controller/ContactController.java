package com.example.phonecontacts.controller;

import com.example.phonecontacts.convertion.ContactConvert;
import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public void addContact(@RequestBody ContactDTO contactDTO, Principal principal) {
        contactService.addNewContact(
                contactConvert.convertDTO(contactDTO),
                principal.getName()
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactDTO> getAllContacts(Principal principal) {
        return contactService.getAllContacts(principal.getName())
                .stream()
                .map(contactConvert::convertEntity)
                .collect(Collectors.toList());
    }

    @PutMapping("/{contactId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateContact(@PathVariable int contactId, @RequestBody ContactDTO contactDTO) {
        contactService.updateContactInfo(contactId,contactConvert.convertDTO(contactDTO));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable int userId) {
        contactService.deleteContactById(userId);
    }

    @DeleteMapping("/name/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserByName(@PathVariable String userName) {
        contactService.deleteContactByName(userName);
    }
}
