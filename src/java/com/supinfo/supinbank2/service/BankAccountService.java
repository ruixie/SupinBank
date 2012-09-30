/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.service;

import com.supinfo.supinbank2.dao.BankAccountDao;
import com.supinfo.supinbank2.entity.BankAccount;
import com.supinfo.supinbank2.entity.BankAccount.InterestPlan;
import com.supinfo.supinbank2.entity.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Thibault
 */
@Stateless
public class BankAccountService {
    
    @EJB
    private BankAccountDao bankAccountDao;
    
    public BankAccount createBankAccount(Integer amount, String name,String interestPlan, Customer customer){
        return bankAccountDao.createBankAccount(amount, name, interestPlan, customer);
    }
    
    public List<BankAccount> getBankAccountByCustomerId(Long customerId){
        return bankAccountDao.getBankAccountByCustomerId(customerId);
    }
    
    public InterestPlan[] getInterestPlan()
    {
        return bankAccountDao.getInterestPlan();
    }
    
}
