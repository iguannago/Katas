package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 17/07/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class BankAccountTest8 {

    private final BankAccount8 bankAccount8 = new BankAccount8();

    @Test
    @Parameters(method = "getAmountOfMoneyBetween1And1000Inclusive")
    public void given1Return1_1(int money) {
        assertEquals(new BigDecimal("1.1"), bankAccount8.getInterest(money));
    }

    private Object[] getAmountOfMoneyBetween1And1000Inclusive() {
        return $(
                $(1), $(500), $(1000)
        );
    }

    @Test
    public void given1001Return1_15() {
        assertEquals(new BigDecimal("1.15"), bankAccount8.getInterest(1001));
    }
    
    



}
