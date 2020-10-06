package com.example.test4.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Alien {

    @Id
    private int id;

    private String username;
    private int password;
    private int balance;


    protected Alien() {

    }

    public Alien(int id,String username,int password,int balance) {
        this.id=id;
        this.password=password;
        this.username=username;
        this.balance=balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", balance=" + balance +
                '}';
    }
}

