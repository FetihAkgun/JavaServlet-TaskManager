package com.example.web1;

public class Gorev {

    private int id;
    private String gorevadi;
    private String gorevaciklama;
    private String gorevoncelik;
    private String gorevdurum;

    public Gorev(int id, String gorevadi, String gorevaciklama, String gorevoncelik, String gorevdurum) {
        this.id = id;
        this.gorevadi = gorevadi;
        this.gorevaciklama = gorevaciklama;
        this.gorevoncelik = gorevoncelik;
        this.gorevdurum = gorevdurum;
    }

    public Gorev(String gorevadi, String gorevaciklama, String gorevoncelik, String gorevdurum) {
        this.gorevadi = gorevadi;
        this.gorevaciklama = gorevaciklama;
        this.gorevoncelik = gorevoncelik;
        this.gorevdurum = gorevdurum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getgorevadi() {
        return gorevadi;
    }

    public void setgorevadi(String gorevadi) {
        this.gorevadi = gorevadi;
    }

    public String getgorevaciklama() {
        return gorevaciklama;
    }

    public void setgorevaciklama(String gorevaciklama) {
        this.gorevaciklama = gorevaciklama;
    }

    public String getgorevoncelik() {
        return gorevoncelik;
    }

    public void setgorevoncelik(String gorevoncelik) {
        this.gorevoncelik = gorevoncelik;
    }
    public String getgorevdurum() {
        return gorevdurum;
    }

    public void setgorevdurum(String gorevdurum) {
        this.gorevdurum = gorevdurum;
    }
}
