package com.example.fitnessuygulamasi;
public class Yemekler {
    int logo;
    String yemekadi;
    String  kalori;

    public Yemekler(int logo, String yemekadi, String kalori) {
        this.logo = logo;
        this.yemekadi = yemekadi;
        this.kalori = kalori;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getYemekadi() {
        return yemekadi;
    }

    public void setYemekadi(String yemekadi) {
        this.yemekadi = yemekadi;
    }

    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }
}