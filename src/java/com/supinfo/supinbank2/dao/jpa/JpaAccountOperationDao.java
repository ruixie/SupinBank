/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao.jpa;
import com.supinfo.supinbank2.dao.AccountOperationDao;
import com.supinfo.supinbank2.entity.AccountOperation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thibault
 */
@Stateless
public class JpaAccountOperationDao implements AccountOperationDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public AccountOperation getAccountOperationByAccountId(Long accountId) {
        return em.find(AccountOperation.class, accountId);
    }
    
}
