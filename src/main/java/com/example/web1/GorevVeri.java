package com.example.web1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GorevVeri
{
    public GorevVeri() {
    }



    public List<Gorev> GorevleriGetir() {
        List<Gorev> Gorevler = new ArrayList<>();

        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT * FROM Gorev ORDER BY id desc";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);

            while(sonuc.next()) {

                int id=sonuc.getInt("id");
                String gorevadi=sonuc.getString("gorevadi");
                String gorevaciklama=sonuc.getString("gorevaciklama");
                String gorevoncelik=sonuc.getString("gorevoncelik");
                String gorevdurum=sonuc.getString("gorevdurum");

                Gorev ogr1=new Gorev(id, gorevadi,gorevaciklama, gorevoncelik, gorevdurum);
                Gorevler.add(ogr1);

            }
           return Gorevler;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
           kapat(baglanti,ifade,sonuc);
        }

    }
    public List<Gorev> acilGorevleriGetir() {
        List<Gorev> Gorevler = new ArrayList<>();

        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT * FROM Gorev where gorevoncelik='yuksek' ORDER BY id desc";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);

            while(sonuc.next()) {

                int id=sonuc.getInt("id");
                String gorevadi=sonuc.getString("gorevadi");
                String gorevaciklama=sonuc.getString("gorevaciklama");
                String gorevoncelik=sonuc.getString("gorevoncelik");
                String gorevdurum=sonuc.getString("gorevdurum");

                Gorev ogr1=new Gorev(id, gorevadi,gorevaciklama, gorevoncelik, gorevdurum);
                Gorevler.add(ogr1);

            }
            return Gorevler;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            kapat(baglanti,ifade,sonuc);
        }

    }

    public List<Gorev> bekleyenGorevleriGetir() {
        List<Gorev> Gorevler = new ArrayList<>();

        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT * FROM Gorev where gorevdurum!='tamamlandi' ORDER BY id desc";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);

            while(sonuc.next()) {

                int id=sonuc.getInt("id");
                String gorevadi=sonuc.getString("gorevadi");
                String gorevaciklama=sonuc.getString("gorevaciklama");
                String gorevoncelik=sonuc.getString("gorevoncelik");
                String gorevdurum=sonuc.getString("gorevdurum");

                Gorev ogr1=new Gorev(id, gorevadi,gorevaciklama, gorevoncelik, gorevdurum);
                Gorevler.add(ogr1);

            }
            return Gorevler;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            kapat(baglanti,ifade,sonuc);
        }

    }
    public int acilgorev() {


        Connection baglanti = null;
        Statement ifade = null;
        ResultSet sonuc = null;
        int acilgorevsayisi = 0;
        try {
            baglanti = VeritabaniBaglanti.veritabaniBaslat();
            String sql = "SELECT COUNT(*) AS sayi FROM gorev where gorevoncelik='yuksek' ";
            ifade = baglanti.createStatement();
            sonuc = ifade.executeQuery(sql);
            if (sonuc.next()) {
                acilgorevsayisi = sonuc.getInt("sayi");
            }

            return acilgorevsayisi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            kapat(baglanti, ifade, sonuc);
        }
    }
    public List<Gorev> tamamlandiGorevleriGetir() {
        List<Gorev> Gorevler = new ArrayList<>();

        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT * FROM Gorev where gorevdurum='tamamlandi' ORDER BY id desc";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);

            while(sonuc.next()) {

                int id=sonuc.getInt("id");
                String gorevadi=sonuc.getString("gorevadi");
                String gorevaciklama=sonuc.getString("gorevaciklama");
                String gorevoncelik=sonuc.getString("gorevoncelik");
                String gorevdurum=sonuc.getString("gorevdurum");

                Gorev ogr1=new Gorev(id, gorevadi,gorevaciklama, gorevoncelik, gorevdurum);
                Gorevler.add(ogr1);

            }
            return Gorevler;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            kapat(baglanti,ifade,sonuc);
        }

    }
    public int toplamGorev() {


        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;
        int tamamlananGorevSayisi = 0;
        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT COUNT(*) AS sayi FROM gorev ";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);
            if (sonuc.next()) {
                tamamlananGorevSayisi = sonuc.getInt("sayi");
            }

            return tamamlananGorevSayisi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            kapat(baglanti,ifade,sonuc);
        }

    }
    public int toplamTamamlananGorev() {


        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;
        int tamamlananGorevSayisi = 0;
        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT COUNT(*) AS sayi FROM gorev where gorevdurum='tamamlandi' ";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);
            if (sonuc.next()) {
                tamamlananGorevSayisi = sonuc.getInt("sayi");
            }

            return tamamlananGorevSayisi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            kapat(baglanti,ifade,sonuc);
        }

    }
    public int toplamBekleyenGorev() {


        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;
        int toplamBekleyenGorev = 0;
        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT COUNT(*) AS sayi FROM gorev where gorevdurum!='tamamlandi' ";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);
            if (sonuc.next()) {
                toplamBekleyenGorev = sonuc.getInt("sayi");
            }

            return toplamBekleyenGorev;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            kapat(baglanti,ifade,sonuc);
        }

    }

    public String GorevSil(int gorevId) {

        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();

            String sql="DELETE FROM gorev WHERE id=?";
            ifade=baglanti.prepareStatement(sql);
            ifade.setInt(1,gorevId);
            ifade.execute();

            boolean isDeleted = ifade.execute();
            if (!isDeleted) {
               return "OK";
            } else {
                return "ERROR";
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public String GorevDuzenle(Gorev gorevdata) {

        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();

            String sql="UPDATE gorev SET gorevadi = ?, gorevaciklama = ?, gorevoncelik = ?, gorevdurum = ? WHERE id = ?";
            ifade=baglanti.prepareStatement(sql);
            ifade.setString(1,gorevdata.getgorevadi());
            ifade.setString(2,gorevdata.getgorevaciklama());
            ifade.setString(3,gorevdata.getgorevoncelik());
            ifade.setString(4,gorevdata.getgorevdurum());
            ifade.setInt(5, gorevdata.getId());

            ifade.execute();

            boolean isUpdate = ifade.execute();
            if (!isUpdate) {
                return "OK";
            } else {
                return "ERROR";
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public String GorevEkle(Gorev gorevdata) {

        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="INSERT INTO gorev (gorevadi, gorevaciklama, gorevoncelik, gorevdurum) VALUES (?, ?, ?, ?)";

            ifade=baglanti.prepareStatement(sql);
            ifade.setString(1,gorevdata.getgorevadi());
            ifade.setString(2,gorevdata.getgorevaciklama());
            ifade.setString(3,gorevdata.getgorevoncelik());
            ifade.setString(4,gorevdata.getgorevdurum());
            ifade.execute();
            boolean isUpdate = ifade.execute();
            if (!isUpdate) {
                return "OK";
            } else {
                return "ERROR";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    private void kapat(Connection baglanti, Statement ifade, ResultSet sonuc){
        try {
            if(sonuc!=null) {
                sonuc.close();
            }
            if(ifade!=null) {
                ifade.close();
            }
            if(baglanti!=null) {
                baglanti.close();
            }
        }catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
