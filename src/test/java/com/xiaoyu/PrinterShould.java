package com.xiaoyu;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.service.exceptions.AmountNotEnoughException;
import com.xiaoyu.service.operator.DepositOperation;
import com.xiaoyu.service.operator.WithdrawalOperation;
import com.xiaoyu.service.operator.impl.DepositOperationImpl;
import com.xiaoyu.service.operator.impl.WithdrawalOperationImpl;
import com.xiaoyu.service.printer.impl.HistoryPrinterImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PrinterShould {
    private Account account;

    @Before
    public void initialise(){
        account = new Account(BigDecimal.ZERO);
        DepositOperation depositOperation = new DepositOperationImpl();
        WithdrawalOperation withdrawalOperation = new WithdrawalOperationImpl();

        depositOperation.deposit(account, BigDecimal.valueOf(500));
        try {
            withdrawalOperation.withdrawal(account, BigDecimal.valueOf(200));
        } catch (AmountNotEnoughException e) {
            System.out.println(e.getMessage());
        }
        depositOperation.deposit(account, BigDecimal.valueOf(100));
        withdrawalOperation.withdrawalAll(account);
        try {
            withdrawalOperation.withdrawal(account, BigDecimal.valueOf(200));
        } catch (AmountNotEnoughException e) {
            System.out.println(e.getMessage());
        }
        depositOperation.deposit(account, BigDecimal.valueOf(456));
        depositOperation.deposit(account, BigDecimal.valueOf(89));
    }

    @Test
    public void testPrinter(){
        HistoryPrinterImpl historyPrinter = new HistoryPrinterImpl();
        historyPrinter.printHistory(account);
    }
}
