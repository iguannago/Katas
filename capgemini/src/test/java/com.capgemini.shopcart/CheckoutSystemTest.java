package com.capgemini.shopcart;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 08/04/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class CheckoutSystemTest {
    public static final BigDecimal APPLE_COST = new BigDecimal("0.60");
    public static final BigDecimal ORANGE_COST = new BigDecimal("0.25");
    private CheckoutSystem checkoutSystem = new CheckoutSystem();
    private List<Item> items = new ArrayList<Item>();

    @Test
    @Parameters(method = "getAmountOfApplesAndOranges")
    public void totalCostTestForAnAppleAndAnOrange(int amountOfApples, int amountOfOranges) {
        createGivenNumberOfApplesAndOrangesAndAddThemToItems(amountOfApples,amountOfOranges);
        BigDecimal expectedResult = getExpectedResult();
        System.out.println("expectedResult: " + expectedResult);
        assertEquals(expectedResult, checkoutSystem.totalCost(items));
    }

    private static final Object[] getAmountOfApplesAndOranges() {
        return new Integer[][]{
                {1,1}, {2,2}, {3,1}, {4,5}, {0,0}, {10, 20}
        };
    }

    private BigDecimal getExpectedResult() {
        BigDecimal expected = new BigDecimal("0.0");
        for (Item item: items) {
            expected = expected.add(item.getCost());
        }
        return expected;
    }

    public void createGivenNumberOfApplesAndOrangesAndAddThemToItems(int numberOfApples, int numberOfOrange){
        Item item;
        for (int i = 0; i < numberOfApples; i++) {
            item = new Apple(APPLE_COST);
            items.add(item);
        }
        for (int i = 0; i < numberOfOrange; i++) {
            item = new Orange(ORANGE_COST);
            items.add(item);
        }
    }

}
