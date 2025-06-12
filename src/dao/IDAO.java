/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author Christopel
 */

import java.util.List;


public interface IDAO<T, ID> {
    public void insert(T var);
    public List<T> showData(ID var);
//    public List<T> showAllData();
    public void update(T var1, ID var2);
    public void delete(ID var);
    public T search(ID var);
}
