package com.example.phonecontacts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Phone contacts",
                version = "1.0",
                description = "Project for CHI Software"
        )
)
public class PhoneContactsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneContactsApplication.class, args);
    }

}
