/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Christopel
 */
public class Rental {
    
    private int id_rental;
    private Date tanggal_rental;
    private Date tanggal_selesai;
    private int id_staff;
    private Film film;

    public Rental(int id_rental, Date tanggal_rental, Date tanggal_selesai, int id_staff) {
        this.id_rental = id_rental;
        this.tanggal_rental = tanggal_rental;
        this.tanggal_selesai = tanggal_selesai;
        this.id_staff = id_staff;
    }

    public Rental(Date tanggal_rental, Date tanggal_selesai, int id_staff) {
        this.tanggal_rental = tanggal_rental;
        this.tanggal_selesai = tanggal_selesai;
        this.id_staff = id_staff;
    }

    public int getId_rental() {
        return id_rental;
    }

    public void setId_rental(int id_rental) {
        this.id_rental = id_rental;
    }

    public Date getTanggal_rental() {
        return tanggal_rental;
    }

    public void setTanggal_rental(Date tanggal_rental) {
        this.tanggal_rental = tanggal_rental;
    }

    public Date getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(Date tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }
    
    public Film getFilm() {
        return film;
    }

    
    
    
    
}
