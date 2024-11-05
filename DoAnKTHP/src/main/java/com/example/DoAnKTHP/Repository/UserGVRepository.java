package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.UserGV;

@Repository
@EnableJpaRepositories
public interface UserGVRepository extends JpaRepository<UserGV, Integer> {
    UserGV findUserGVByUserName(String username);
}
