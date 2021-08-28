package com.cinema.demo1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String emailId;
    @Column(nullable = false, length = 25)
    private String userName;
    @Column(nullable = false, length = 65)
    private String password;

    public User() {
    }

    public User(int id, String emailId, String userName, String password) {
        this.id = id;
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getEmailId() {return emailId;}
    public void setEmailId(String emailId) {this.emailId = emailId;}

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}

