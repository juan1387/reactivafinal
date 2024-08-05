package com.reto.juancamilo.DTO;

public class Cashoutrequest {
    private String userid;
    private Long amount;

    public Cashoutrequest(Long amount, String userid) {
        this.amount = amount;
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
