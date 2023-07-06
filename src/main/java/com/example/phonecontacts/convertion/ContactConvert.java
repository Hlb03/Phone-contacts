package com.example.phonecontacts.convertion;

import com.example.phonecontacts.builder.ContactBuilder;
import com.example.phonecontacts.builder.ContactDTOBuilder;
import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.entity.Contact;
import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ContactConvert {

    private final ContactBuilder builder;
    private final ContactDTOBuilder dtoBuilder;;

    public ContactConvert(ContactBuilder builder, ContactDTOBuilder dtoBuilder) {
        this.builder = builder;
        this.dtoBuilder = dtoBuilder;
    }

    public ContactDTO convertEntity(Contact contact) {
        ContactDTO dto = dtoBuilder
                .setId(contact.getId())
                .setName(contact.getName())
                .setEmails(contact.getEmails())
                .setPhones(contact.getPhoneNumbers())
                .build();
//        System.out.println("DTO: " + dto);
        return dto;
    }

    public Contact convertDTO(ContactDTO contactDTO) {
        return builder
                .setId(contactDTO.getId())
                .setName(contactDTO.getName())
                .setEmails(contactDTO.getEmails())
                .setPhones(contactDTO.getPhones())
                .build();
    }
}
