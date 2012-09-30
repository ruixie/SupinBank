/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Thibault
 */
@Entity
public class AccountOperation implements Serializable {
   
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
    private Integer ammount;
    public Integer getAmmount() {
        return ammount;
    }
    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }
    
    @NotEmpty(message="Date cannot be empty")
    @NotNull(message="Date cannot be null")
    @Past(message="Date must be in the past")
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    @NotEmpty(message="Wording cannot be empty")
    @NotNull(message="Wording cannot be null")
    @Size(min=3, max=150, message="Wording must be between 3 and 150 character")
    @Column(nullable=false)
    private String wording;
    public String getWording() {
        return wording;
    }
    public void setWording(String wording) {
        this.wording = wording;
    }
    
    @NotEmpty(message="Account operation must have a bank account")
    @NotNull(message="Account operation must have a bank account")
    @ManyToOne
    private BankAccount bankAccount;
    public BankAccount getBankAccount() {
        return bankAccount;
    }
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public AccountOperation() {
    }

    public AccountOperation(Integer ammount, Date date, String wording, BankAccount bankAccount) {
        this.ammount = ammount;
        this.date = date;
        this.wording = wording;
        this.bankAccount = bankAccount;
    }
    
    

}
