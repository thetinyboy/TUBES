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




public class StaffDAO implements IDAO<Staff, Integer>{
    private Connection con;
    private DbConnection dbCon = new DbConnection();
    
    
    @Override
    public void insert(Staff s) {
        con = dbCon.makeConnection();
        String sql = "INSERT INTO staff (nama) VALUES ('" + s.getNama() + "')";
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
    public List<Staff> showData(Integer id_staff) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM staff";
        List<Staff> list = new ArrayList<>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Staff(
                    rs.getInt("id_staff"),
                    rs.getString("nama")
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
    public void update(Staff s, Integer id_staff) {
        con = dbCon.makeConnection();
        String sql = "UPDATE staff SET nama = '" + s.getNama() + "' WHERE id_staff = " + id_staff;
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
    public void delete(Integer id_staff) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM staff WHERE id_staff = " + id_staff;
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
    public Staff search(Integer id_staff) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM staff WHERE id_staff = " + id_staff;
        Staff s = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                s = new Staff(
                    rs.getInt("id_staff"),
                    rs.getString("nama")
                );
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        dbCon.closeConnection();
        return s;
    }
}