/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Christopel
 */
public class CustomerDAO implements IDAO<Customer, Integer>{
    
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Customer C)
    {
        con = dbCon.makeConnection();
        
        String sql = 
                "INSERT INTO `customer` (`nama`, `alamat`, `no_telepon`, `nik`) " +
                "VALUES ('" + C.getNama() + "', '" + C.getAlamat() + "', '" + C.getNo_telepon() + "', '" + C.getNik() + "' )" ;
               
        System.out.println("Adding Customer...");
        
        try
        {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added" + result + " Customer");
            
            statement.close();
            
        }
        catch(Exception e)
        {
            System.out.println("Error adding customer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public List<Customer> showData(Integer data)
    {
        con = dbCon.makeConnection();
        
        String sql = 
                "SELECT * FROM customer";
        System.out.println("Fetching Data...");
        
        List<Customer> c = new ArrayList<>();
        
        try
        {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
            {
                while(rs.next())
                {
                    c.add(new Customer(
                            rs.getInt("id_customer"),
                            rs.getString("nama"),
                            rs.getString("no_telepon"),
                            rs.getString("alamat"),
                            rs.getString("nik")));
                }
            }
            rs.close();
            statement.close();
        }
        catch(Exception e)
        {
            System.out.println("Error fetching data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        
        return c;
    }
    
    @Override
    public void update(Customer c, Integer id_customer)
    {
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `customer` SET "
           + "`nama`='" + c.getNama() + "', "
           + "`alamat`='" + c.getAlamat() + "', "
           + "`no_telepon`='" + c.getNo_telepon() + "', "
           + "`nik`='" + c.getNik() + "' "
           + "WHERE `id_customer`='" + id_customer + "'";
        
        System.out.println("Updating customer...");
        
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Customer " + id_customer);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error updating customer...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    
    }
    
    
    @Override
    public void delete(Integer id_customer)
    {
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM `customer` WHERE `id_customer` = '"
                + id_customer + "'";
        
        
        System.out.println("Deleting Customer...");
        
        try
        {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            
            System.out.println("Edited " + result + " Customer " + id_customer);
            statement.close();
        }catch(Exception e)
        {
            System.out.println("Error Deleting Customer");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    @Override
    public Customer search(Integer id_customer)
    {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM customer WHERE id_customer = '" + id_customer + "'";
        System.out.println("Searching Customer...");
        
        Customer c = null;
        
        try
        {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null)
            {
                while(rs.next())
                {
                    c = new Customer(
                            rs.getInt("id_customer"),
                            rs.getString("nama"),
                            rs.getString("no_telepon"),
                            rs.getString("alamat"),
                            rs.getString("nik"));
                }
                
                
            }
            rs.close();
            statement.close();
        }
        catch(Exception e)
        {
            System.out.println("Error fetching data...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        
        return c;
    }
    
    
}
