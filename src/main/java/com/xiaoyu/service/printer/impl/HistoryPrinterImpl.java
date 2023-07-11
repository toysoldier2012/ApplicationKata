package com.xiaoyu.service.printer.impl;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.pojo.Operation;
import com.xiaoyu.service.printer.HistoryPrinter;

import java.util.ArrayList;

public class HistoryPrinterImpl implements HistoryPrinter {
    @Override
    public void printHistory(Account account) {
        System.out.println("Your account's history :");
        ArrayList<Operation> operations = account.getOperations();
        for (Operation operation : operations) {
            System.out.println("Created at : " + operation.getOperationCreatedTime());
            System.out.println("Operation is : " + operation.getType());
            System.out.println("Amount is : " + operation.getAmount());
            System.out.println("Balance is : " + operation.getBalance());
        }

    }
}
