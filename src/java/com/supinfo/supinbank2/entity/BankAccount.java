/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Thibault
 */
@Entity
public class BankAccount implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @NotEmpty(message="Amount cannot be empty")
    @NotNull(message="Amount cannot be null")
    @Column(nullable=false)
    private Integer amount;
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
    @NotEmpty(message="Name cannot be empty")
    @NotNull(message="Name cannot be null")
    @Size(min=3, max=150, message="Name must be between 3 and 150 character")
    @Column(nullable=false)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountsOperationList;
    public List<AccountOperation> getAccountsOperationList() {
        return accountsOperationList;
    }
    public void setAccountsOperationList(List<AccountOperation> accountsOperationList) {
        this.accountsOperationList = accountsOperationList;
    }
    
    @NotEmpty(message="Bank account must have a customer")
    @NotNull(message="Bank account must have a customer")
    @ManyToOne
    private Customer customer;
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BankAccount() {
    }

    public BankAccount(Integer amount, String name, String interestPlan, Customer customer) {
        this.amount = amount;
        this.name = name;
        this.customer = customer;
        this.interestPlan = InterestPlan.valueOf(interestPlan);
    }
    
  
    public enum InterestPlan{
        CURRENTACCOUNT("Current Account"),
        SAVERACCOUNT("First Home Saver Account"),
        LIFEINSURANCE("Life Insurance"),
        SAVINGSACCOUNT("Savings Account");
    
        private InterestPlan(String value){
        this.value = value;
        }
    
        private final String value;
        public String toString() {
        return value;
        }
    }
    
    @Enumerated(EnumType.STRING)
    private InterestPlan interestPlan;

    public InterestPlan getInterestPlan() {
        return interestPlan;
    }

    public void setInterestPlan(InterestPlan interestPlan) {
        this.interestPlan = interestPlan;
    }
}
