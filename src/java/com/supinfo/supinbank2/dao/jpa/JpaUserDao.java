/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao.jpa;

import com.supinfo.supinbank2.dao.UserDao;
import com.supinfo.supinbank2.entity.BankAdvisor;
import com.supinfo.supinbank2.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.supinfo.supinbank2.tools.BCrypt;

/**
 *
 * @author Thibault
 */

//Cette classe devrait etre refactorisé !
@Stateless
public class JpaUserDao implements UserDao {

    @PersistenceContext()
    private EntityManager em;

    @Override
    public boolean IsCustomer(String email, String password) {
        List<Object> customerList = em.createQuery("SELECT user FROM Customer user where email = :email").setParameter("email", email).getResultList();
        if (customerList.isEmpty()) {
            return false;
        } else {
            //Customer customer = new Customer();
            Customer customer = (Customer) customerList.get(0);
            String customerPassword = customer.getPassword();
            boolean isValide = BCrypt.checkpw(password, customerPassword);
            if (isValide) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean IsBankAdvisor(String email, String password) {
        List<Object> bankAdvisorList = em.createQuery("SELECT user FROM BankAdvisor user where email = :email").setParameter("email", email).getResultList();
        if (bankAdvisorList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
