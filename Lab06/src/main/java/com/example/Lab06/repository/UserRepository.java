package com.example.Lab06.repository;

import com.example.Lab06.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
