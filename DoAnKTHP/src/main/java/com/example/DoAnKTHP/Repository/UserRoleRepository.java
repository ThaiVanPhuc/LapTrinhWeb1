package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.User_Role;

@Repository
public interface UserRoleRepository extends JpaRepository<User_Role, Long> {
}
