/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supinbank2.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Thibault
 */
@Entity
@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class UserBaseClass implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message="Email cannot be empty")
    @NotNull(message="Email cannot be null")
    @Size(min=5, max=40, message="Email must be between 5 and 40 character")
    @Pattern(regexp="\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", message="Email must be a real mail address")
    @Column(nullable=false)
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @NotEmpty(message="Password cannot be empty")
    @NotNull(message="Password cannot be null")
    @Size(min=6, max=20, message="Password must be between 6 and 20 character")
    @Column(nullable=false)
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @NotEmpty(message="Fistname cannot be empty")
    @NotNull(message="Fistname cannot be null")
    @Size(min=2, max=30, message="Fistname must be between 2 and 30 character")
    @Column(nullable=false)
    private String firstname;
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    @NotEmpty(message="Lastname cannot be empty")
    @NotNull(message="Lastname cannot be null")
    @Size(min=2, max=30, message="Lastname must be between 2 and 30 character")
    @Column(nullable=false)
    private String lastname;
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public UserBaseClass() {
    }

    public UserBaseClass(String email, String firstname, String lastname, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }
    
    
}
