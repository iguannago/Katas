package com.searchings;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by davicres on 08/06/2015.
 */
public class BankAccountTest {

    @Test
    public void bankAccountIsOpen() {
        BankAccount bankAccount = BankAccount.open(0);
        Assert.assertNotNull(bankAccount);
    }

    @Test
    public void bankAccountIsOpenWithEspecifiedAmount() {
        BankAccount bankAccount = BankAccount.open(100);
        Assert.assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void makeADepositInBankAccount() {
        Calculator calculator = mock(Calculator.class);
        when(calculator.add(100, 10)).thenReturn(110);
        BankAccount bankAccount = BankAccount.open(100);
        bankAccount.setCalculator(calculator);
        Assert.assertEquals(110, bankAccount.makeADeposit(10).getBalance());
    }

}
