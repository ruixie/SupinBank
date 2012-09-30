/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao.jpa;
import com.supinfo.supinbank2.dao.BankAccountDao;
import com.supinfo.supinbank2.entity.BankAccount;
import com.supinfo.supinbank2.entity.BankAccount.InterestPlan;
import com.supinfo.supinbank2.entity.Customer;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thibault
 */
@Stateless
public class JpaBankAccountDao implements BankAccountDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public BankAccount createBankAccount(Integer amount, String name,String interestPlan, Customer customer) {
        BankAccount bankAccount = new BankAccount(amount, name, interestPlan, customer);
        em.persist(bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> getBankAccountByCustomerId(Long customerId) {
         return em.createQuery("SELECT ba FROM BankAccount ba where customer_id = :id").setParameter("id", customerId).getResultList();
    }

    @Override
    public InterestPlan[] getInterestPlan()
    {
        return InterestPlan.values();
    }
    
}
