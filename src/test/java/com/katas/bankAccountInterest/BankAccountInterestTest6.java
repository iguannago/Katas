package com.katas.bankAccountInterest;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

/**
 * Created by davicres on 29/12/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class BankAccountInterestTest6 {

    @Test
    @Parameters(method = "getAmountBetween1And1000BothIncluded")
    public void givenAnAmountBetween1And1000BothIncludedThenReturns1_1InterestTest(int amountBetween1And1000) {
        BankAccountInterest6 bankAccountInterest6 = new BankAccountInterest6();
        BigDecimal interest = bankAccountInterest6.getRightInterest(amountBetween1And1000);
    }

    private static final Object[] getAmountBetween1And1000BothIncluded() {
        return new Integer[][]{
                {1}, {234}, {500}, {1000}
        };
    }
}
