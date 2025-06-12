/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Christopel
 */
public class Staff {
    
    private int id_staff;
    private String nama;

    public Staff(int id_staff, String nama) {
        this.id_staff = id_staff;
        this.nama = nama;
    }

    public Staff(String nama) {
        this.nama = nama;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
}
