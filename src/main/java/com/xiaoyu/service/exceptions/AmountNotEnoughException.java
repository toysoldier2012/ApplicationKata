package com.xiaoyu.service.exceptions;

public class AmountNotEnoughException extends Exception{
    public AmountNotEnoughException() {
        super("The balance is not enough.");
    }
}
