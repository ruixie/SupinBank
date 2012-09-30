/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao;

import com.supinfo.supinbank2.entity.Customer;
import java.util.List;

/**
 *
 * @author Thibault
 */
public interface CustomerDao {
    
    Customer createCustomer(String email, String firstname, String lastname, String adresse, String zipcode, String city, String phone);
    
    Customer persistCustomer(Customer customer);
    
    List<Customer> getAllCustomer();
    
    Customer getCustomerById(Long id);
    
    Customer getCustomerByEmail(String email);
    
}
