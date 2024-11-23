package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.DoAnKTHP.models.LichGiangVien;

import java.util.List;

@Repository
public interface LichGiangVienRepository extends JpaRepository<LichGiangVien, Long> {
    @Query("SELECT l FROM LichGiangVien l WHERE l.giangVien.id = :giangVienId ORDER BY l.thu ASC")
    List<LichGiangVien> findByGiangVienId(Long giangVienId);
}
