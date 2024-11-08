package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.GiangVien;

@Repository
@EnableJpaRepositories
public interface UserGVRepository extends JpaRepository<GiangVien, Integer> {
    GiangVien findUserGVByUserName(String username);
}
