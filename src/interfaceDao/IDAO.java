/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import connection.DbConnection;
import idao.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Lucas Manuel SB
 */
public interface IDAO<T, I> {
    public void insert(T data);
    public List<T> showData(I data);
    public void update(T data, I data2);
    public void delete(I data);
    public T search(I data);
}
