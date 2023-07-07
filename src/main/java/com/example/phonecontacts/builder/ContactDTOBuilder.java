package com.example.phonecontacts.builder;

import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactDTOBuilder {

    private ContactDTO contactDTO;

    public ContactDTOBuilder builder() {
        contactDTO = new ContactDTO();
        return this;
    }

    public ContactDTOBuilder setId(int id) {
        contactDTO.setId(id);
        return this;
    }

    public ContactDTOBuilder setName(String name) {
        contactDTO.setName(name);
        return this;
    }

    public ContactDTOBuilder setPhones(List<PhoneNumber> numbers) {
        contactDTO.setPhones(numbers);
        return this;
    }

    public ContactDTOBuilder setEmails(List<Email> emails) {
        contactDTO.setEmails(emails);
        return this;
    }

    public ContactDTO build() {
        return contactDTO;
    }
}
