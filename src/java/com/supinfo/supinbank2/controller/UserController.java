/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.controller;

import com.supinfo.supinbank2.entity.UserBaseClass;
import com.supinfo.supinbank2.service.CustomerService;
import com.supinfo.supinbank2.service.LoginService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Thibault
 */
@ManagedBean
@RequestScoped
public class UserController {

    /**
     * Creates a new instance of UserController
     */
    
    @EJB
    private LoginService loginService;
    
    @EJB
    private CustomerService customerService;
    
    private String email = "toto";
    private String password;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String login(){
    
        String outcome = null;
        
        boolean IsCustomer = loginService.IsCustomer(this.email, this.password);
        boolean IsBankAdvisor = loginService.IsBankAdvisor(email, password);

        if (IsCustomer) {
            user = "customer";
            outcome = "customer_home";
            //request.getSession().setAttribute("user", "customer");
            String id = customerService.getCustomerByEmail(email).getId().toString();
            //response.sendRedirect(getServletContext().getContextPath() + "/listcustomeraccount?id=" + id);
        } else if (IsBankAdvisor) {
            user = "bankadvisor";
            outcome = "bankadvisor_home";
            //request.getSession().setAttribute("user", "bank");
            //response.sendRedirect(getServletContext().getContextPath() + "/listcustomer");
        } else {
            
            //response.sendRedirect(request.getServletContext().getContextPath() + "/index.jsp");
        }
        
        return outcome;
        
    }
    
    public UserController() {
    }
}
