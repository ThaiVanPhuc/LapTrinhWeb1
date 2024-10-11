package com.example.KiemTraGiuaKi.repositories;

import com.example.KiemTraGiuaKi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}