package com.example.userrecordmanagement.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
    extends JpaRepository<User, Long> {

        @Query("SELECT u From User u where u.email = ?1")
        Optional<User> findUserByEmail(String email);
}