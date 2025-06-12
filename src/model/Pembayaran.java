/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Christopel
 */
public class Pembayaran {
    
    private int id_pembayaran;
    private float amount;
    private String metode;
    private int id_rental;
    private int id_staff;

    public Pembayaran(int id_pembayaran, float amount, String metode, int id_rental, int id_staff) {
        this.id_pembayaran = id_pembayaran;
        this.amount = amount;
        this.metode = metode;
        this.id_rental = id_rental;
        this.id_staff = id_staff;
    }

    public Pembayaran(float amount, String metode, int id_rental, int id_staff) {
        this.amount = amount;
        this.metode = metode;
        this.id_rental = id_rental;
        this.id_staff = id_staff;
    }

    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public int getId_rental() {
        return id_rental;
    }

    public void setId_rental(int id_rental) {
        this.id_rental = id_rental;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    
    
}
