/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao;

import com.supinfo.supinbank2.entity.AccountOperation;

/**
 *
 * @author Thibault
 */
public interface AccountOperationDao {
    
    AccountOperation getAccountOperationByAccountId(Long accountId);

}
