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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static java.util.EnumSet.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class PrinterShould {
    private Account account;
    private DepositOperation depositOperation;
    private WithdrawalOperation withdrawalOperation;

    @Before
    public void initialise() {
        account = new Account(BigDecimal.ZERO);
        depositOperation = new DepositOperationImpl();
        withdrawalOperation = new WithdrawalOperationImpl();
    }

    @Test
    public void should_print_history_of_account_in_order() throws AmountNotEnoughException {
        depositOperation.deposit(account, BigDecimal.valueOf(500));
        withdrawalOperation.withdrawal(account, BigDecimal.valueOf(200));
        withdrawalOperation.withdrawalAll(account);

        String sExpected1 = "Your account's history :";
        String sExpected2 = "Operation is : DEPOSIT";
        String sExpected3 = "Amount is : 500";
        String sExpected4 = "Balance is : 500";
        String sExpected5 = "Operation is : WITHDRAW";
        String sExpected6 = "Amount is : 200";
        String sExpected7 = "Balance is : 300";
        String sExpected8 = "Operation is : WITHDRAW";
        String sExpected9 = "Amount is : 300";
        String sExpected10 = "Balance is : 0";

        HistoryPrinterImpl historyPrinter = new HistoryPrinterImpl();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        historyPrinter.printHistory(account);
        System.out.flush();
        System.setOut(old);
        String sActual = baos.toString();

        assertThat(sActual, containsString(sExpected1));
        assertThat(sActual, containsString(sExpected2));
        assertThat(sActual, containsString(sExpected3));
        assertThat(sActual, containsString(sExpected4));
        assertThat(sActual, containsString(sExpected5));
        assertThat(sActual, containsString(sExpected6));
        assertThat(sActual, containsString(sExpected7));
        assertThat(sActual, containsString(sExpected8));
        assertThat(sActual, containsString(sExpected9));
        assertThat(sActual, containsString(sExpected10));
    }
}
