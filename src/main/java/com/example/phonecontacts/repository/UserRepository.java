package com.example.phonecontacts.repository;

import com.example.phonecontacts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByUserName(String username);

    void deleteByUserName(String mail);
}
