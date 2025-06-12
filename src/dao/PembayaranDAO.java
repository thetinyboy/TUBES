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
import model.*;

/**
 *
 * @author Christopel
 */


public class PembayaranDAO implements IDAO<Pembayaran, Integer>{
    private Connection con;
    private DbConnection dbCon = new DbConnection();
    
    
    @Override
    public void insert(Pembayaran p) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO pembayaran (amount, metode, id_rental, id_staff) VALUES ("
                + p.getAmount() + ", '" + p.getMetode() + "', "
                + p.getId_rental() + ", " + p.getId_staff() + ")";
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
    public List<Pembayaran> showData(Integer data) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM pembayaran";
        List<Pembayaran> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Pembayaran(
                    rs.getInt("id_pembayaran"),
                    rs.getFloat("amount"),
                    rs.getString("metode"),
                    rs.getInt("id_rental"),
                    rs.getInt("id_staff")
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
    public void update(Pembayaran p, Integer id_pembayaran) {
        con = dbCon.makeConnection();
        String sql = "UPDATE pembayaran SET "
                + "amount = " + p.getAmount() + ", "
                + "metode = '" + p.getMetode() + "', "
                + "id_rental = " + p.getId_rental() + ", "
                + "id_staff = " + p.getId_staff()
                + " WHERE id_pembayaran = " + id_pembayaran;
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
    public void delete(Integer id_pembayaran) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM pembayaran WHERE id_pembayaran = " + id_pembayaran;
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
    public Pembayaran search(Integer id_pembayaran) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM pembayaran WHERE id_pembayaran = " + id_pembayaran;
        Pembayaran p = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                p = new Pembayaran(
                    rs.getInt("id_pembayaran"),
                    rs.getFloat("amount"),
                    rs.getString("metode"),
                    rs.getInt("id_rental"),
                    rs.getInt("id_staff")
                );
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
        return p;
    }
}