package com.xiaoyu.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operation extends Entity {
    private LocalDateTime operationCreatedTime;
    private BigDecimal amount;
    private Type type;
    private BigDecimal balance;

    public Operation(BigDecimal amount, Type type) {
        this.operationCreatedTime = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
        this.balance = BigDecimal.ZERO;
    }

    public Operation(BigDecimal amount, Type type, BigDecimal balance) {
        this.operationCreatedTime = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
        this.balance = balance;
    }

    public LocalDateTime getOperationCreatedTime() {
        return operationCreatedTime;
    }
    public void setOperationCreatedTime(LocalDateTime operationCreatedTime) {
        this.operationCreatedTime = operationCreatedTime;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public Type getType()
    {
        return type;
    }
    public void setType(Type type)
    {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
