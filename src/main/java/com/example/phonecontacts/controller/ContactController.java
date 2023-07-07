package com.example.phonecontacts.controller;

import com.example.phonecontacts.mappers.ContactMapper;
import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
@Tag(name = "ContactController", description = "This controller is responsible for user contacts manipulations")
public class ContactController {

    private final ContactService contactService;
    private final ContactMapper contactMapper;

    public ContactController(ContactService contactService, ContactMapper contactConvert) {
        this.contactService = contactService;
        this.contactMapper = contactConvert;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Creates new contact to authorized user")
    public void addContact(@RequestBody ContactDTO contactDTO, Principal principal) {
        System.out.println(contactDTO);
        contactService.addNewContact(
                contactMapper.convertDTO(contactDTO),
                principal.getName()
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Returns all contacts to authorized user")
    public List<ContactDTO> getAllContacts(Principal principal) {
        return contactService.getAllContacts(principal.getName())
                .stream()
                .map(contactMapper::convertEntity)
                .collect(Collectors.toList());
    }

    @PutMapping("/{contactId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Updates/Creates certain contact by its id")
    public void updateContact(@PathVariable int contactId, @RequestBody ContactDTO contactDTO) {
        contactService.updateContactInfo(contactId, contactMapper.convertDTO(contactDTO));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Deletes certain contact by its id")
    public void deleteUserById(@PathVariable int userId) {
        contactService.deleteContactById(userId);
    }

    @DeleteMapping("/name/{userName}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Deletes certain contact by its name")
    public void deleteUserByName(@PathVariable String userName) {
        contactService.deleteContactByName(userName);
    }
}
