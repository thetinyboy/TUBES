/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Christopel
 */
public class Customer {
    
    private int id_customer;
    private String nama;
    private String no_telepon;
    private String alamat;
    private String nik;

    public Customer(int id_customer, String nama_customer, String no_telepon, String alamat, String nik) {
        this.id_customer = id_customer;
        this.nama = nama_customer;
        this.no_telepon = no_telepon;
        this.alamat = alamat;
        this.nik = nik;
    }

    public Customer(String nama_customer, String no_telepon, String alamat, String nik) {
        this.nama = nama_customer;
        this.no_telepon = no_telepon;
        this.alamat = alamat;
        this.nik = nik;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama_customer) {
        this.nama = nama_customer;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    
    
    
}
