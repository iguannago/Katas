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
    public void get1_1InterestTest(int money) {
        assertEquals(new BigDecimal("1.1"), bankAccount8.getInterest(money));
    }

    private Object[] getAmountOfMoneyBetween1And1000Inclusive() {
        return $(
                $(1), $(500), $(1000)
        );
    }

    @Test
    @Parameters(method = "getAmountOfMoneyBetween1001And2000Inclusive")
    public void get1_15InterestTest(int money) {
        assertEquals(new BigDecimal("1.15"), bankAccount8.getInterest(money));
    }

    private Object[] getAmountOfMoneyBetween1001And2000Inclusive() {
        return $(
                $(1001), $(1501), $(2000)
        );
    }

    @Test
    @Parameters(method = "getAmountOfMoneyBetween2001And3000Inclusive")
    public void get1_22InterestTest(int money) {
        assertEquals(new BigDecimal("1.22"), bankAccount8.getInterest(money));
    }

    private Object[] getAmountOfMoneyBetween2001And3000Inclusive() {
        return $(
                $(2001), $(2500), $(3000)
        );
    }

    @Test
    public void get1_3InterestTest() {
        assertEquals(new BigDecimal("1.3"), bankAccount8.getInterest(3001));
    }



    



}
