package com.example.phonecontacts.builder;

import com.example.phonecontacts.dto.ContactDTO;
import com.example.phonecontacts.entity.Email;
import com.example.phonecontacts.entity.PhoneNumber;

import java.util.List;

public interface ContactDTOBuilder {

    ContactDTOBuilder setId(int id);

    ContactDTOBuilder setName(String name);
//
    ContactDTOBuilder setPhones(List<PhoneNumber> numbers);
//
    ContactDTOBuilder setEmails(List<Email> emails);

    ContactDTO build();
}
