package com.example.phonecontacts.jwttest;

import com.example.phonecontacts.util.JsonTokenUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JsonTokenUtilTest {

    @Autowired
    JsonTokenUtil tokenUtil;

    @DisplayName("Test retrieving information from generated token")
    @Test
    void retrieveDataFromToken() {
        String[] userNames = {"first", "1234", "--__--", "Ÿžœ"};

        User[] users = {
                new User(userNames[0], userNames[0], new ArrayList<>()),
                new User(userNames[1], userNames[1], new ArrayList<>()),
                new User(userNames[2], userNames[2], new ArrayList<>()),
                new User(userNames[3], userNames[3], new ArrayList<>()),
        };

        ArrayList<String> token = new ArrayList<>();
        for (User u : users)
            token.add(tokenUtil.generateToken(u));

        assertAll(
                () -> {
                    assertEquals(userNames[0], tokenUtil.getUsernameFromToken(token.get(0)));
                    assertEquals(userNames[1], tokenUtil.getUsernameFromToken(token.get(1)));
                    assertEquals(userNames[2], tokenUtil.getUsernameFromToken(token.get(2)));
                    assertEquals(userNames[3], tokenUtil.getUsernameFromToken(token.get(3)));
                }
        );
    }
}
