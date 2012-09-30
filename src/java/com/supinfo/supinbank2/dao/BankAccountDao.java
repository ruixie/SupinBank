/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao;

import com.supinfo.supinbank2.entity.BankAccount;
import com.supinfo.supinbank2.entity.Customer;
import java.util.List;

/**
 *
 * @author Thibault
 */
public interface BankAccountDao {
    
    BankAccount createBankAccount(Integer amount, String name, String interestPlan, Customer customer);
    
    List<BankAccount> getBankAccountByCustomerId(Long customerId);
    
    BankAccount.InterestPlan[] getInterestPlan();
}
