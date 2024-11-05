package com.example.DoAnKTHP.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.DoAnKTHP.models.LichPhongMay;

@Repository
public interface LichPhongMayRepository extends JpaRepository<LichPhongMay, Long> {
    List<LichPhongMay> findByNgayAndCaAndTrangThai(Date ngay, int ca, boolean trangThai);
}
