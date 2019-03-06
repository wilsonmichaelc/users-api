package com.wilson.seed.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames = {"guid"})})
public class User extends AuditModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
        name = "user_generator",
        sequenceName = "user_generator",
        initialValue = 1000
    )
    private Long id;

    @NotBlank
    
    @Column(columnDefinition = "guid")
    private String guid;

    @Column(columnDefinition = "name")
    private String name;

    @NotBlank
    @Column(columnDefinition = "email")
    private String email;

    @Column(columnDefinition = "phone")
    @Size(min = 10, max = 20)
    private String phone;

    @Column(columnDefinition = "address_one")
    private String addressOne;  
    
    @Column(columnDefinition = "address_two")
    private String addressTwo;

    public User() {
        
    }

    public User(String guid, String name, String email, String phone, String addressOne, String addressTwo) {
        this.guid = guid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param guid the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * @param guid the guid to set
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the addressOne
     */
    public String getAddressOne() {
        return addressOne;
    }

    /**
     * @param addressOne the addressOne to set
     */
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    /**
     * @return the addressTwo
     */
    public String getAddressTwo() {
        return addressTwo;
    }

    /**
     * @param addressTwo the addressTwo to set
     */
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }
}