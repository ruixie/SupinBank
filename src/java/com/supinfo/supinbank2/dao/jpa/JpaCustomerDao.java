/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.dao.jpa;
import com.supinfo.supinbank2.dao.CustomerDao;
import com.supinfo.supinbank2.entity.Customer;
import com.supinfo.supinbank2.tools.BCrypt;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thibault
 */
@Stateless
public class JpaCustomerDao implements CustomerDao {

    @PersistenceContext()
    private EntityManager em;
    
    @Override
    public Customer createCustomer(String email, String firstname, String lastname, String adresse, String zipcode, String city, String phone) {
        String randomPassword = UUID.randomUUID().toString();
        Customer newCustomer = new Customer(email,firstname,lastname,randomPassword, adresse,zipcode,city,phone);
        return newCustomer;
    }
    
    @Override
    public Customer persistCustomer(Customer customer){
        
        //Genere le randon password
        String hashedRandomPassword = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt());
        customer.setPassword(hashedRandomPassword);
        em.persist(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return em.createQuery("SELECT c FROM Customer c").getResultList();
    }
    
    @Override
    public Customer getCustomerById(Long id){
        return em.find(Customer.class, id);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return (Customer) em.createQuery("SELECT user FROM Customer user where email = :email").setParameter("email", email).getSingleResult();
    }
    
}
