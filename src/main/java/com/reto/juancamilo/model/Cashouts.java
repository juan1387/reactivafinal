package com.reto.juancamilo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("cashouts")
public class Cashouts {

    @Id
    private long id;
    @Column("userid")
    private String userId;
    @Column("amount")
    private float amount;

    public Cashouts() {
    }

    public Cashouts(long id, String userId, float amount) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
