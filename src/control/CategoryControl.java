/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import model.Category;
import dao.CategoryDAO;

/**
 *
 * @author Christopel
 */
public class CategoryControl {
    
    private CategoryDAO cDAO = new CategoryDAO();
    
    public void insert(Category c)
    {
        cDAO.insert(c);
    }
    
    public List<Category> showData()
    {
        List<Category> data = cDAO.IShowForDropdown();
        return data;
    }        
                    
    public void update(Category c, Integer id_category)
    {
        cDAO.update(c, id_category);
    }
    
    public void delete(Integer id_category)
    {
        cDAO.delete(id_category);
    }     
            
    public Category search(Integer id_category) 
    {
        return cDAO.search(id_category);
    }
}
