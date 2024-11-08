package com.example.DoAnKTHP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.DoAnKTHP.models.LichPhongMay;

@Repository
public interface LichPhongMayRepository extends JpaRepository<LichPhongMay, Long> {
    List<LichPhongMay> findPhongTrongByCaAndThu(int ca, int thu);
}
