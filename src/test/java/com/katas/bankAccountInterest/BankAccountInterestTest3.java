package com.katas.bankAccountInterest;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 30/04/2015.
 */
public class BankAccountInterestTest3 {

    private BankAccountInterest3 bankAccountInterest3;

    @Before
    public void setUp() throws Exception {
        bankAccountInterest3 = new BankAccountInterest3();
    }

    @Test
    public void ifAmountIs0ThenInterestIs1_1() {
        assertEquals(new BigDecimal("1.1"), bankAccountInterest3.giveMeInterestOf(0));
    }
    @Test
    public void ifAmountIs1ThenInterestIs1_1() {
        assertEquals(new BigDecimal("1.1"), bankAccountInterest3.giveMeInterestOf(1));
    }
    @Test
    public void ifAmountIs1000ThenInterestIs1_1() {
        assertEquals(new BigDecimal("1.1"), bankAccountInterest3.giveMeInterestOf(1000));
    }
    @Test
    public void ifAmountIs1001ThenInterestIs1_15() {
        assertEquals(new BigDecimal("1.15"), bankAccountInterest3.giveMeInterestOf(1001));
    }
    @Test
    public void ifAmountIs1002ThenInterestIs1_15() {
        assertEquals(new BigDecimal("1.15"), bankAccountInterest3.giveMeInterestOf(1002));
    }
    @Test
    public void ifAmountIs2001ThenInterestIs1_22() {
        assertEquals(new BigDecimal("1.22"), bankAccountInterest3.giveMeInterestOf(2001));
    }
    @Test
    public void ifAmountIs2002ThenInterestIs1_22() {
        assertEquals(new BigDecimal("1.22"), bankAccountInterest3.giveMeInterestOf(2002));
    }
    @Test
    public void ifAmountIs3001ThenInterestIs1_3() {
        assertEquals(new BigDecimal("1.3"), bankAccountInterest3.giveMeInterestOf(3001));
    }
    @Test
    public void ifAmountIs3002ThenInterestIs1_3() {
        assertEquals(new BigDecimal("1.3"), bankAccountInterest3.giveMeInterestOf(3002));
    }

//    Testing boundaries and no happy paths.

    @Test(expected=RuntimeException.class)
    public void ifAmountIsNegativeThenThrowException() {
    bankAccountInterest3.giveMeInterestOf(-1);
    }


}
