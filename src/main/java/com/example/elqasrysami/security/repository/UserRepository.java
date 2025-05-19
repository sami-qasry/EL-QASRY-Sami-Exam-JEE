package com.example.elqasrysami.security.repository;

import com.example.elqasrysami.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
    Optional<User> findByPhone(String phone);
    Optional<User> findByPasswordReset(String passwordReset);
}
