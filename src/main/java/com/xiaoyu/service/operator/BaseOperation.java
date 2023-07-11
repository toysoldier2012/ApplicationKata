package com.xiaoyu.service.operator;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.pojo.Operation;

import java.util.ArrayList;

public abstract class BaseOperation {
    protected void updateOperations(Account account, Operation operation){
        ArrayList<Operation> operations = account.getOperations();
        operations.add(operation);
        account.setOperations(operations);
    }
}
