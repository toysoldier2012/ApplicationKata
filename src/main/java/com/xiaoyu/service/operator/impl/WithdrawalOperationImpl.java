package com.xiaoyu.service.operator.impl;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.pojo.Operation;
import com.xiaoyu.pojo.Type;
import com.xiaoyu.service.operator.BaseOperation;
import com.xiaoyu.service.operator.WithdrawalOperation;
import com.xiaoyu.service.exceptions.AmountNotEnoughException;

import java.math.BigDecimal;
import java.util.ArrayList;

public class WithdrawalOperationImpl extends BaseOperation implements WithdrawalOperation {
    @Override
    public void withdrawal(Account account, BigDecimal amount) throws AmountNotEnoughException {
        checkAmount(account, amount);

        Operation operation = new Operation(amount, Type.WITHDRAW);
        account.setAmount(account.getAmount().subtract(operation.getAmount()));
        operation.setBalance(account.getAmount());

        ArrayList<Operation> operations = account.getOperations();
        operations.add(operation);
        account.setOperations(operations);
    }

    @Override
    public void withdrawalAll(Account account) {
        Operation operation = new Operation(account.getAmount(), Type.WITHDRAW);
        account.setAmount(BigDecimal.ZERO);

        ArrayList<Operation> operations = account.getOperations();
        operations.add(operation);
        account.setOperations(operations);
    }

    @Override
    public void checkAmount(Account account, BigDecimal amount) throws AmountNotEnoughException {
        if (account.getAmount().compareTo(amount) == -1) throw new AmountNotEnoughException("Not enough amount");
    }
}
