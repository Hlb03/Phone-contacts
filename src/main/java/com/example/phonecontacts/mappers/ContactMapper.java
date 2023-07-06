package com.example.phonecontacts.convertion;

import com.example.phonecontacts.builder.ContactBuilder;
import com.example.phonecontacts.builder.ContactDTOBuilder;
import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactConvert {

    private final ContactBuilder builder;
    private final ContactDTOBuilder dtoBuilder;;

    public ContactConvert(ContactBuilder builder, ContactDTOBuilder dtoBuilder) {
        this.builder = builder;
        this.dtoBuilder = dtoBuilder;
    }

    public ContactDTO convertEntity(Contact contact) {
        //        System.out.println("DTO: " + dto);
        return dtoBuilder
                .setId(contact.getId())
                .setName(contact.getName())
                .setEmails(contact.getEmails())
                .setPhones(contact.getPhoneNumbers())
                .build();
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
