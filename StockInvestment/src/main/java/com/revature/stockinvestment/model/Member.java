/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.model;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author James
 */
@Entity
@Table(name = "MEMBER")
public class Member {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="memSeq")
    @SequenceGenerator(allocationSize=1, name="memSeq", sequenceName="SQ_MEMBER_PK")
    @Column(name = "MEMBER_ID")
    private int memberId;
    
    @NotNull
    @Pattern(regexp = "[a-z-A-Z]*")
    @Size(min = 1, max = 20)
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 20)
    private String firstName;
    
    @NotNull
    @Pattern(regexp = "[a-z-A-Z]*")
    @Size(min = 1, max = 20)
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 20)
    private String lastName;
    
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL", unique = true, nullable = false, length = 30)
    private String email;
    
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PASSWORD", unique = false, nullable = false, length = 40)
    private String password;

    public int getMemberId() { 
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
