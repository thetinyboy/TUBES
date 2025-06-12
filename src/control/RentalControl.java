/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.RentalDAO;
import java.util.List;
import model.Rental;
import table.TableSewaFilm;

/**
 *
 * @author Christopel
 */
public class RentalControl {
    
    private RentalDAO rDAO = new RentalDAO();
    
    public void insert(Rental r)
    {
        rDAO.insert(r);
    }
    
    public List<Rental> showData(String target)
    {
        return rDAO.showData(target);
    }        
                    
    public void update(Rental r, String id_category)
    {
        rDAO.update(r, id_category);
    }
    
    public void delete(String id_category)
    {
        rDAO.delete(id_category);
    }     
            
    public Rental search(String id_category) 
    {
        return rDAO.search(id_category);
    } 
    
    public TableSewaFilm showTable(String target){
        List<Rental> dataRental = rDAO.showData(target);
        TableSewaFilm tableSewaFilm = new TableSewaFilm(dataRental);
        
        for(Rental rental : dataRental){
            System.out.println(rental.getFilm().getJudul());
        }
        
        return tableSewaFilm;
    }
}
