package com.katas.bankAccountInterest;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 07/08/2015.
 */
public class BankAccountInterestTest4 {

    private BankAccountInterest4 bankAccountInterest4;

    @Before
    public void setUp() throws Exception {
        bankAccountInterest4 = new BankAccountInterest4();
    }

    @Test
    public void whenAmountIs0ThenInterest1_1Test() {
        assertEquals(new BigDecimal("1.1"), bankAccountInterest4.tellMeInterest(0));
    }

    @Test
    public void whenAmountIs1ThenInterest1_1Test() {
        assertEquals(new BigDecimal("1.1"), bankAccountInterest4.tellMeInterest(1));
    }

    @Test
    public void whenAmountIs1001ThenInterest1_15Test() {
        assertEquals(new BigDecimal("1.15"), bankAccountInterest4.tellMeInterest(1001));
    }

    @Test
    public void whenAmountIs2000ThenInterest1_15Test() {
        assertEquals(new BigDecimal("1.15"), bankAccountInterest4.tellMeInterest(2000));
    }

    @Test
    public void whenAmountIs2001ThenInterest1_22Test() {
        assertEquals(new BigDecimal("1.22"), bankAccountInterest4.tellMeInterest(2001));
    }

    @Test
    public void whenAmountIs3000ThenInterest1_22Test() {
        assertEquals(new BigDecimal("1.22"), bankAccountInterest4.tellMeInterest(3000));
    }

    @Test
    public void whenAmountI3001ThenInterest1_3Test() {
        assertEquals(new BigDecimal("1.3"), bankAccountInterest4.tellMeInterest(3001));
    }

    //unhappy paths: throw exception if amount is negative.
    @Test(expected = RuntimeException.class)
    public void whenAmountIsLessThan0ThenThrowException() {
        bankAccountInterest4.tellMeInterest(-1);
    }


}
