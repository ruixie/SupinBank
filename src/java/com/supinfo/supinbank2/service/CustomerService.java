/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.service;

import com.supinfo.supinbank2.dao.CustomerDao;
import com.supinfo.supinbank2.entity.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Thibault
 */
@Stateless
public class CustomerService {
    
    @EJB
    private CustomerDao customerDao;
    
    public Customer createCustomer(String email, String firstname, String lastname, String adresse, String zipcode, String city, String phone){
        return customerDao.createCustomer(email, firstname, lastname, adresse, zipcode, city, phone);
    }
    
    public Customer persistCustomer(Customer customer){
        return customerDao.persistCustomer(customer);
    }
    
    public List<Customer> getAllCustomer(){
        return customerDao.getAllCustomer();
    }
    
    public Customer getCustomerById(Long id){
        return customerDao.getCustomerById(id);
    }
    
     public Customer getCustomerByEmail(String email)
     {
         return customerDao.getCustomerByEmail(email);
     }
    
}
