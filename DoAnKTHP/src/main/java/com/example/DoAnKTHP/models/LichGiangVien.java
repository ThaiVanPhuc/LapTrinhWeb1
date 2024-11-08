package com.example.DoAnKTHP.models;

import jakarta.persistence.*;

@Entity
@Table(name = "lich_giang_vien")
public class LichGiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long giangvienId;
    private int ca;
    private int thu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGiangvienId() {
        return giangvienId;
    }

    public void setGiangvienId(Long giangvienId) {
        this.giangvienId = giangvienId;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

}
