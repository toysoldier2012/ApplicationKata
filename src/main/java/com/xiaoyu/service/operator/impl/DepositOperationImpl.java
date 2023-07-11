package com.xiaoyu.service.operator.impl;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.pojo.Operation;
import com.xiaoyu.pojo.Type;
import com.xiaoyu.service.operator.DepositOperation;
import com.xiaoyu.service.operator.BaseOperation;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DepositOperationImpl extends BaseOperation implements DepositOperation {
    @Override
    public void deposit(Account account, BigDecimal amount) {
        Operation operation = new Operation(amount, Type.DEPOSIT);
        account.setAmount(account.getAmount().add(operation.getAmount()));
        operation.setBalance(account.getAmount());

        ArrayList<Operation> operations = account.getOperations();
        operations.add(operation);
        account.setOperations(operations);
    }

}
