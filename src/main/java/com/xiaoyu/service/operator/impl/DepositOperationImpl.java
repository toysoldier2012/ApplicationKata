package com.xiaoyu.service.operator.impl;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.pojo.Operation;
import com.xiaoyu.pojo.Type;
import com.xiaoyu.service.operator.DepositOperation;
import com.xiaoyu.service.operator.BaseOperation;

import java.math.BigDecimal;

public class DepositOperationImpl extends BaseOperation implements DepositOperation {
    @Override
    public void deposit(Account account, BigDecimal amount) {
        account.setAmount(account.getAmount().add(amount));
        updateOperations(account, new Operation(amount, Type.DEPOSIT, account.getAmount()));
    }
}
