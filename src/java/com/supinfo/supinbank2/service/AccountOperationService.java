/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.service;

import com.supinfo.supinbank2.dao.AccountOperationDao;
import com.supinfo.supinbank2.entity.AccountOperation;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Thibault
 */
@Stateless
public class AccountOperationService {
    
    @EJB
    private AccountOperationDao accountOperationDao;
    
    public AccountOperation getAccountOperationByAccountId(Long accountId){
        return accountOperationDao.getAccountOperationByAccountId(accountId);
    }
    
}
