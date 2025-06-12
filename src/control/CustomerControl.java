/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.CustomerDAO;
import java.util.List;
import model.Customer;

/**
 *
 * @author Christopel
 */
public class CustomerControl {
    
    private CustomerDAO cDAO = new CustomerDAO();
    
    public void insert(Customer C)
    {
        cDAO.insert(C);
    }
    
    public List<Customer> showData(String target)
    {
        int target2 = Integer.parseInt(target);
        return cDAO.showData(target2);
    }
    
    public void update(Customer c, Integer id_customer)
    {
        cDAO.update(c, id_customer);
    }
    
    public void delete(Integer id_customer)
    {
        cDAO.delete(id_customer);
    }
    
    public Customer search(Integer id_customer)
    {
        return cDAO.search(id_customer);
    }
            
}
