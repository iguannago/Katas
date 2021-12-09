package com.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by davicres on 08/06/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {

    private
    @Mock
    Calculator calculator;

    @Test
    public void bankAccountShouldBeOpen() {
        BankAccount bankAccount = BankAccount.open(0);
        Assert.assertNotNull(bankAccount);
    }

    @Test
    public void bankAccountShouldBeOpenWithEspecifiedAmount() {
        BankAccount bankAccount = BankAccount.open(100);
        Assert.assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void aDepositShouldbeMadeInBankAccount() {
        when(calculator.add(100, 10)).thenReturn(110);
        BankAccount bankAccount = BankAccount.open(100);
        bankAccount.setCalculator(calculator);
        Assert.assertEquals(110, bankAccount.makeADeposit(10).getBalance());
    }

}
