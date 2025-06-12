/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.StaffDAO;
import java.util.List;
import model.Staff;

/**
 *
 * @author Christopel
 */
public class StaffControl {
    
    private StaffDAO sDAO = new StaffDAO();
    
    public void insert(Staff s)
    {
        sDAO.insert(s);
    }
    
    public List<Staff> showData(Integer id_category)
    {
        return sDAO.showData(id_category);
    }        
                    
    public void update(Staff s, Integer id_category)
    {
        sDAO.update(s, id_category);
    }
    
    public void delete(Integer id_category)
    {
        sDAO.delete(id_category);
    }     
            
    public Staff search(Integer id_category) 
    {
        return sDAO.search(id_category);
    }
}
