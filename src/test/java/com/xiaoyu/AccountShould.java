package com.xiaoyu;

import com.xiaoyu.pojo.Account;
import com.xiaoyu.pojo.Operation;
import com.xiaoyu.pojo.Type;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class AccountShould {
    private Account account;
    private Operation operation1;
    private Operation operation2;
    private Operation operation3;

    @Before
    public void initialise(){
        account = new Account(BigDecimal.ZERO);
        operation1 = new Operation(BigDecimal.valueOf(300), Type.DEPOSIT);
        operation2 = new Operation(BigDecimal.valueOf(200), Type.DEPOSIT);
        operation3 = new Operation(BigDecimal.valueOf(100), Type.WITHDRAW);
    }

    @Test
    public void isAccountOperationsKeepOrder(){
        ArrayList<Operation> operations = account.getOperations();
        operations.add(operation1);
        operations.add(operation2);
        operations.add(operation3);
        account.setOperations(operations);

        assertEquals(account.getOperations().get(0), operation1);
        assertEquals(account.getOperations().get(1), operation2);
        assertEquals(account.getOperations().get(2), operation3);
    }
}
