package com.xiaoyu.service.operator;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.service.exceptions.AmountNotEnoughException;

import java.math.BigDecimal;

public interface WithdrawalOperation {
    void withdrawal(Account account, BigDecimal amount) throws AmountNotEnoughException;
    void withdrawalAll(Account account);
    void checkAmount(Account account, BigDecimal amount) throws AmountNotEnoughException;
}
