package com.xiaoyu.service.operator.impl;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.pojo.Operation;
import com.xiaoyu.pojo.Type;
import com.xiaoyu.service.operator.BaseOperation;
import com.xiaoyu.service.operator.WithdrawalOperation;
import com.xiaoyu.service.exceptions.AmountNotEnoughException;

import java.math.BigDecimal;

public class WithdrawalOperationImpl extends BaseOperation implements WithdrawalOperation {
    @Override
    public void withdrawal(Account account, BigDecimal amount) throws AmountNotEnoughException {
        checkAmount(account, amount);
        account.setAmount(account.getAmount().subtract(amount));
        updateOperations(account, new Operation(amount, Type.WITHDRAW, account.getAmount()));
    }

    @Override
    public void withdrawalAll(Account account) {
        updateOperations(account, new Operation(account.getAmount(), Type.WITHDRAW));
        account.setAmount(BigDecimal.ZERO);
    }

    @Override
    public void checkAmount(Account account, BigDecimal amount) throws AmountNotEnoughException {
        if (account.getAmount().compareTo(amount) == -1) throw new AmountNotEnoughException();
    }
}
