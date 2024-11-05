package com.example.DoAnKTHP.models;

import java.util.Date;
import java.util.List;

public class LichDeXuat {
    private Date ngay;
    private int ca;
    private List<String> phong;
    private String giangVien;
    private String lop;

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public List<String> getPhong() {
        return phong;
    }

    public void setPhong(List<String> phong) {
        this.phong = phong;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

}
