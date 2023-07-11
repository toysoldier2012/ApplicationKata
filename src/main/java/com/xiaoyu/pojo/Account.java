package com.xiaoyu.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Account extends Entity{
    private BigDecimal amount;
    private ArrayList<Operation> operations = new ArrayList<>();

    public Account(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }
    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }
}
