/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.service;

import com.supinfo.supinbank2.dao.UserDao;
import com.supinfo.supinbank2.entity.Customer;
import com.supinfo.supinbank2.entity.UserBaseClass;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Thibault
 */
@Stateless
public class LoginService {
    
    @EJB
    private UserDao userDao;
    
    public boolean IsCustomer(String email, String password){
         return userDao.IsCustomer(email, password);
    }
    
    public boolean IsBankAdvisor(String email, String password){
         return userDao.IsBankAdvisor(email, password);
    }
}
