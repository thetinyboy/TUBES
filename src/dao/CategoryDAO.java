/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import connection.DbConnection;
import interfaceDao.IShowForDropdown;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import model.*;


/**
 *
 * @author Christopel
 */


public class CategoryDAO implements IDAO<Category, Integer>, IShowForDropdown<Category>{
    private Connection con;
    private DbConnection dbCon = new DbConnection();
    
    @Override
    public List<Category> IShowForDropdown(){
        con = dbCon.makeConnection();

        String sql = "SELECT jenis FROM kategori\n";

        System.out.println("Fetching Data...");

        List<Category> list = new ArrayList();

        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Category c = null;

            if (rs != null)
                while (rs.next()) {
                    c = new Category(
                    rs.getString("kategori"));
                    list.add(c);
                }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    @Override
    public void insert(Category c) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO kategori (jenis) VALUES ('" + c.getJenis() + "')";
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public List<Category> showData(Integer target) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM kategori";
        List<Category> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Category(
                    rs.getInt("id_kategori"),
                    rs.getString("jenis")
                ));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    
    @Override
    public void update(Category c, Integer id_category) {
        con = dbCon.makeConnection();
        String sql = "UPDATE kategori SET jenis = '" + c.getJenis() + "' WHERE id_kategori = " + id_category;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public void delete(Integer id_category) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM kategori WHERE id_kategori  = " + id_category;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public Category search(Integer id_category) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM kategori WHERE id_kategori = " + id_category;
        Category c = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                c = new Category(
                    rs.getInt("id_kategori"),
                    rs.getString("jenis")
                );
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
        return c;
    }
}