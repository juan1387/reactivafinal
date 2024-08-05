package com.reto.juancamilo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class Users {
    @Id
    private String id;
    @Column("nombre")
    private String name;

    public Users(String id) {
        this.id = id;
    }

    public Users(String id, float balance) {
        this.id = id;
        this.balance = balance;
    }

    @Column("balance")
    private float balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
