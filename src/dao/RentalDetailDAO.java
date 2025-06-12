/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Christopel
 */

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import model.*;


public class RentalDetailDAO{
    private Connection con;
    private DbConnection dbCon = new DbConnection();

    
    
    public void insert(RentalDetail rd) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO rental_detail (id_rental, id_film) " +
                     "VALUES (" + rd.getId_rental() + ", " + rd.getId_film() + ")";
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    public List<RentalDetail> showData() {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM rental_detail";
        List<RentalDetail> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new RentalDetail(
                    rs.getInt("id_rental"),
                    rs.getInt("id_film")
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
    
    
    public void deleteByRentalId(int id_rental) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM rental_detail WHERE id_rental = " + id_rental;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    public void deleteByFilmId(int id_film) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM rental_detail WHERE id_film = " + id_film;
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    public List<RentalDetail> searchByRentalId(int id_rental) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM rental_detail WHERE id_rental = " + id_rental;
        List<RentalDetail> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new RentalDetail(
                    rs.getInt("id_rental"),
                    rs.getInt("id_film")
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
    
}