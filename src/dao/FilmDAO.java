/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import model.Film;

/**
 *
 * @author Christopel
 */

public class FilmDAO implements IDAO<Film, Integer>{
    
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Film f) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO film (judul, tahun_rilis, rating, id_kategori) " +
                     "VALUES ('" + f.getJudul() + "', '" + f.getTahun_rilis() + "', " + f.getRating() + ", " + f.getId_category() + ")";
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
    public List<Film> showData(Integer data) 
    {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM film";
        List<Film> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Film(
                    rs.getInt("id_film"),
                    rs.getString("judul"),
                    rs.getString("tahun_rilis"),
                    rs.getInt("id_kategori")
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
    public void update(Film f, Integer id_film) {
        con = dbCon.makeConnection();
        String sql = "UPDATE film SET " +
                     "judul = '" + f.getJudul() + "', " +
                     "tahun_rilis = '" + f.getTahun_rilis() + "', " +
                     "rating = " + f.getRating() + ", " +
                     "id_kategori = " + f.getId_category() + " " +
                     "WHERE id_film = " + id_film;
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
    public void delete(Integer id_film) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM film WHERE id_film = " + id_film;
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
    public Film search(Integer id_film) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM film WHERE id_film = " + id_film;
        Film f = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                f = new Film(
                    rs.getInt("id_film"),
                    rs.getString("judul"),
                    rs.getString("tahun_rilis"),
                    rs.getInt("id_kategori")
                );
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
        return f;
    }
    
    public int generateId()
    {
        con = dbCon.makeConnection();
        
        String sql = "SELECT MAX(CAST(SUBSTRING(id_film, 2) AS SIGNED)) AS highest_number FROM film WHERE id_film LIKE 'F%';";
        
        System.out.println("Generating Id...");
        int id = 0;
        
        try {
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null && rs.next())
            {
                if(!rs.wasNull())
                {
                    id = rs.getInt("highest_number") + 1;
                }
                
                rs.close();
                statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error Fetching Data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return id;
    }
}
