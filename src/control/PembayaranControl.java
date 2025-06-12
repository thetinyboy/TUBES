/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PembayaranDAO;
import java.util.List;
import model.Pembayaran;

/**
 *
 * @author Christopel
 */
public class PembayaranControl {
    
    
    private PembayaranDAO pDAO = new PembayaranDAO();
    
    public void insert(Pembayaran p)
    {
        pDAO.insert(p);
    }
    
    public List<Pembayaran> showData(String target)
    {
        int target2 = Integer.parseInt(target);
        return pDAO.showData(target2);
    }        
                    
    public void update(Pembayaran p, Integer id_category)
    {
        pDAO.update(p, id_category);
    }
    
    public void delete(Integer id_category)
    {
        pDAO.delete(id_category);
    }     
            
    public Pembayaran search(Integer id_category) 
    {
        return pDAO.search(id_category);
    }
}
