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
import java.text.SimpleDateFormat;
import java.util.Date;


public class RentalDAO implements IDAO<Rental, String>{
    private Connection con;
    private DbConnection dbCon = new DbConnection();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void insert(Rental r) {
        con = dbCon.makeConnection();
        String tanggalRental = sdf.format(r.getTanggal_rental());
        String tanggalSelesai = sdf.format(r.getTanggal_selesai());

        String sql = "INSERT INTO rental (tanggal_pinjam, tanggal_kembali, id_staff) VALUES ('"
                + r.getTanggal_rental() + "', '" + r.getTanggal_selesai() + "', " + r.getId_staff() + ")";
        
        System.out.println("Adding Rental Data");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Rental");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error occured");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public List<Rental> showData(String query) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM rental R JOIN customer C ON R.id_customer = C.id_customer " +
             "JOIN staff S ON R.id_staff = S.id_staff" + 
             "JOIN detail_rental dr ON dr.id_rental = R.id_rental" + 
             "JOIN film f ON f.id_film = dr.id_film" + 
             "JOIN kategori k ON f.id_kategori = k.id_kategori" + 
             "WHERE R.id_rental LIKE '%" + query + "%' " +
             "OR R.tanggal_rental LIKE '%" + query + "%' " +
             "OR R.tanggal_selesai LIKE '%" + query + "%' " +
             "OR f.judul LIKE '%" + query + "%' " +
             "OR C.id_customer LIKE '%" + query + "%' " +
             "OR S.id_staff LIKE '%" + query + "%'";
        
        System.out.println("Fetching data");
        
        List<Rental> list = new ArrayList<>();
        Film f = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null)
            {
                while (rs.next()) {
                    Customer c = new Customer(
                    rs.getInt("c.id_customer"),
                    rs.getString("c.nama"),
                    rs.getString("c.alamat"),
                    rs.getString("c.no_telepon"),
                    rs.getString("c.nik")
                );
                    
                    f = new Film(
                        rs.getInt("f.id_film"),
                        rs.getString("f.judul"),
                        rs.getString("f.tahun_rilis"),
                        rs.getInt("f.id_kategori")
                    );

                    Rental r = new Rental(
                        rs.getInt("id_rental"),
                        rs.getDate("tanggal_pinjam"),
                        rs.getDate("tanggal_kembali"),
                        rs.getInt("id_staff")
                    );
                    list.add(r);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("Success");
        dbCon.closeConnection();
        return list;
    }
    
    
    
    @Override
    public void update(Rental r, String id_rental) {
        con = dbCon.makeConnection();
        String tanggalRental = sdf.format(r.getTanggal_rental());
        String tanggalSelesai = sdf.format(r.getTanggal_selesai());

        String sql = "UPDATE rental SET "
                + "tanggal_pinjam  = '" + tanggalRental + "', "
                + "tanggal_kembali = '" + tanggalSelesai + "', "
                + "id_staff = " + r.getId_staff()
                + " WHERE id_rental = " + id_rental;
        
        System.out.println("Editing Data");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Rental ID " + id_rental);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    
    @Override
    public void delete(String id_rental) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM rental WHERE id_rental = " + id_rental;
        System.out.println("Deleting data");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Rental ID " + id_rental);
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
    @Override
    public Rental search(String id_rental) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM rental WHERE id_rental = " + id_rental;
        Rental r = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Date tanggalRental = rs.getDate("tanggal_pinjam");
                Date tanggalSelesai = rs.getDate("tanggal_kembali");
                r = new Rental(
                    rs.getInt("id_rental"),
                    tanggalRental,
                    tanggalSelesai,
                    rs.getInt("id_staff")
                );
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error searching");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return r;
    }
}
