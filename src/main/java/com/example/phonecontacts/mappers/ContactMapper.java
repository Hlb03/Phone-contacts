package com.example.phonecontacts.mappers;

import com.example.phonecontacts.builder.ContactBuilder;
import com.example.phonecontacts.builder.ContactDTOBuilder;
import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    private final ContactBuilder builder;
    private final ContactDTOBuilder dtoBuilder;;

    public ContactMapper(ContactBuilder builder, ContactDTOBuilder dtoBuilder) {
        this.builder = builder;
        this.dtoBuilder = dtoBuilder;
    }

    public ContactDTO convertEntity(Contact contact) {
        return dtoBuilder
                .builder()
                .setId(contact.getId())
                .setName(contact.getName())
                .setEmails(contact.getEmails())
                .setPhones(contact.getPhoneNumbers())
                .build();
    }

    public Contact convertDTO(ContactDTO contactDTO) {
        return builder
                .builder()
//                .setId(contactDTO.getId())
                .setName(contactDTO.getName())
                .setEmails(contactDTO.getEmails())
                .setPhones(contactDTO.getPhones())
                .build();
    }
}
