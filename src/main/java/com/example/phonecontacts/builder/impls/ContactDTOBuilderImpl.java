package com.example.phonecontacts.builder.impls;

import com.example.phonecontacts.builder.ContactDTOBuilder;
import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactDTOBuilderImpl implements ContactDTOBuilder {

    private final ContactDTO contactDTO;

    public ContactDTOBuilderImpl() {
        this.contactDTO = new ContactDTO();
    }

    @Override
    public ContactDTOBuilder setId(int id) {
        contactDTO.setId(id);
        return this;
    }

    @Override
    public ContactDTOBuilder setName(String name) {
        contactDTO.setName(name);
        return this;
    }

    @Override
    public ContactDTOBuilder setPhones(List<PhoneNumber> numbers) {
        contactDTO.setPhones(numbers);
        return this;
    }

    @Override
    public ContactDTOBuilder setEmails(List<Email> emails) {
        contactDTO.setEmails(emails);
        return this;
    }

    @Override
    public ContactDTO build() {
        return contactDTO;
    }
}
