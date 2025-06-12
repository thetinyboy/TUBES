/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Christopel
 */
public class Category {
    
    private int id_category;
    private String jenis;

    public Category(int id_category, String jenis) {
        this.id_category = id_category;
        this.jenis = jenis;
    }

    public Category(String jenis) {
        this.jenis = jenis;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    @Override
    public String toString(){
        return getJenis();
    }
}
