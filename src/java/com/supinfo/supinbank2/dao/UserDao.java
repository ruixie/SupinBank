/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao;

import com.supinfo.supinbank2.entity.Customer;
import com.supinfo.supinbank2.entity.UserBaseClass;

/**
 *
 * @author Thibault
 */
public interface UserDao {
    
    boolean IsCustomer(String emai, String passwordl);
    
    boolean IsBankAdvisor(String email, String password);
            
}
