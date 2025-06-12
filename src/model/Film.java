/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import fetch.FilmRatingFetcher;

/**
 *
 * @author Christopel
 */
public class Film {
    
    private int id_film;
    private String judul;
    private String tahun_rilis;
    private float rating;
    private int id_category;
    
    
    public Film(int id_film, String judul, String tahun_rilis, int id_category) {
        try {
            this.id_film = id_film;
            this.judul = judul;
            this.tahun_rilis = tahun_rilis;
//            this.rating = Float.parseFloat(FilmRatingFetcher.getRating(judul));
            this.id_category = id_category;  
            
            System.out.println("Rating " + rating);
        } catch (Exception e) {
            System.out.println("Failed Construct Data");
        }
      
    }

    public Film(String judul, String tahun_rilis, int id_category) {
        try {
            this.judul = judul;
            this.tahun_rilis = tahun_rilis;
//            this.rating = Float.parseFloat(FilmRatingFetcher.getRating(judul));
            this.id_category = id_category;   
        } catch (Exception e) {
            System.out.println("Failed Construct Data");
        }
    }

    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTahun_rilis() {
        return tahun_rilis;
    }

    public void setTahun_rilis(String tahun_rilis) {
        this.tahun_rilis = tahun_rilis;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
    
    @Override
    public String toString() {
        return "Film {" +
               "\n  ID         : " + id_film +
               "\n  Judul      : " + judul +
               "\n  Tahun Rilis: " + tahun_rilis +
               "\n  Rating     : " + rating +
               "\n  Kategori ID: " + id_category +
               "\n}";
    }
    
}
