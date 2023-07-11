package com.xiaoyu.service.operator;

import com.xiaoyu.pojo.Account;

import java.math.BigDecimal;

public interface DepositOperation {
    void deposit(Account account, BigDecimal amount);
}
