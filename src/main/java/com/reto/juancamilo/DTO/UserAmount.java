package com.reto.juancamilo.DTO;

public class UserAmount {
    private long amount;

    public UserAmount(long amount) {
        this.amount = amount;
    }

    public UserAmount() {
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
