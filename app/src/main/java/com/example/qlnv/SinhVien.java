package com.example.qlnv;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String mssv;
    private String ten;
    private String tuoi;

    public SinhVien() {
    }

    public SinhVien(String mssv, String ten,String tuoi) {
        this.mssv = mssv;
        this.ten = ten;
        this.tuoi=tuoi;
    }



    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }
}
