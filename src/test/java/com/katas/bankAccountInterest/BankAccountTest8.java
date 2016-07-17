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
    @Parameters(method = "getAmountOfMoney")
    public void given1Return1_1(int money) {
        assertEquals(bankAccount8.getInterest(money), new BigDecimal("1.1"));
    }

    private Object[] getAmountOfMoney() {
        return $(
                $(1), $(500), $(1000)
        );
    }

}
