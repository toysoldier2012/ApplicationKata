package com.xiaoyu;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AccountShould.class, OperationShould.class, PrinterShould.class})
public class AllTests {}