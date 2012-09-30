/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Thibault
 */
@Entity
public class Customer extends UserBaseClass implements Serializable {

@NotEmpty(message="Adresse cannot be empty")
@NotNull(message="Adresse cannot be null")
@Size(min=3, max=150, message="Adresse must be between 3 and 150 character")
@Column(nullable=false)
private String adresse;
public String getAdresse() {
        return adresse;
    }
public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
@NotEmpty(message="Zip code cannot be empty")
@NotNull(message="Zip code cannot be null")
@Size(min=4, max=10, message="Zip code must be between 4 and 10 character")
@Column(nullable=false)
private String zipcode;
public String getZipcode() {
        return zipcode;
    }
public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
@NotEmpty(message="City cannot be empty")
@NotNull(message="City cannot be null")
@Size(min=1, max=100, message="City must be between 1 and 100 character")
@Column(nullable=false)
private String city;
public String getCity() {
        return city;
    }
public void setCity(String city) {
        this.city = city;
    }
    
@NotEmpty(message="Phone cannot be empty")
@NotNull(message="Phone cannot be null")
@Size(min=1, max=16, message="Phone must be between 1 and 16 character")
@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}", message="Phone must respect the following pattern : (ddd)ddd-dddd")
@Column(nullable=false)
private String phone;
public String getPhone() {
        return phone;
    }
public void setPhone(String phone) {
        this.phone = phone;
    }

@NotEmpty(message="Customer must have at least one BankAccount")
@NotNull(message="Customer must have at least one BankAccount")
@Column(nullable=false)
@OneToMany(mappedBy = "customer")
private List<BankAccount> bankAccountList;
public List<BankAccount> getBankAccount() {
        return bankAccountList;
    }
public void setBankAccount(List<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public Customer() {
    }

    public Customer(String email, String firstname, String lastname, String password, String adresse, String zipcode, String city, String phone) {
        super(email,firstname,lastname,password);
        this.adresse = adresse;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
    }


  
}
