/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import model.Film;
import dao.FilmDAO;


/**
 *
 * @author Christopel
 */
public class FilmControl {
    
    private FilmDAO fDAO = new FilmDAO();
    
    public String generateId()
    {
        return "F" + fDAO.generateId();
    }
    
    public void insert(Film f)
    {
        fDAO.insert(f);
    }
    
    public List<Film> showData(String target)
    {
//        int target2 = Integer.parseInt(target);
//        return fDAO.showData(target2);
        return null;
    }        
                    
    public void update(Film f, Integer id_category)
    {
        fDAO.update(f, id_category);
    }
    
    public void delete(Integer id_category)
    {
        fDAO.delete(id_category);
    }     
            
    public Film search(Integer id_category) 
    {
        return fDAO.search(id_category);
    }
}
