package com.xiaoyu;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.service.exceptions.AmountNotEnoughException;
import com.xiaoyu.service.operator.impl.DepositOperationImpl;
import com.xiaoyu.service.operator.impl.WithdrawalOperationImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class OperationShould {
    private Account account;

    @Before
    public void initialise(){
        account = new Account(BigDecimal.valueOf(500));
    }

    @Test
    public void should_deposit_add_operation(){
        DepositOperationImpl depositOperation = new DepositOperationImpl();
        depositOperation.deposit(account, BigDecimal.valueOf(1000));

        assertEquals(BigDecimal.valueOf(1500), account.getAmount());
        assertEquals(1, account.getOperations().size());
    }

    @Test
    public void should_throw_exception_when_withdrawal_if_account_dont_have_enough_money(){
        WithdrawalOperationImpl withdrawalOperation = new WithdrawalOperationImpl();

        assertThrows(AmountNotEnoughException.class, () -> withdrawalOperation.withdrawal(account, BigDecimal.valueOf(900)));

        withdrawalOperation.withdrawalAll(account);
        assertEquals(BigDecimal.ZERO, account.getAmount());
    }
}
