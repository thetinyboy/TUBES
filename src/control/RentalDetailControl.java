/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.RentalDetailDAO;
import java.util.ArrayList;
import java.util.List;
import model.RentalDetail;

/**
 *
 * @author Christopel
 */
public class RentalDetailControl {
    
    private RentalDetailDAO rDAO = new RentalDetailDAO();
    
    public void insert(RentalDetail r)
    {
        rDAO.insert(r);
    }
    
    public List<RentalDetail> showData()
    {
        return rDAO.showData();
    }        
                    
    public void deleteByRentalId(int id_rental) {
        rDAO.deleteByRentalId(id_rental);
    }
    
    
    
    public void deleteByFilmId(int id_film) {
       rDAO.deleteByFilmId(id_film);
    }
    
    
    public List<RentalDetail> searchByRentalId(int id_rental) {
        return rDAO.searchByRentalId(id_rental);
    }
}
