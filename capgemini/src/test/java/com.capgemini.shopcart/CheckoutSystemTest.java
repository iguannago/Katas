package com.capgemini.shopcart;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 08/04/2016.
 */
public class CheckoutSystemTest {
    public static final BigDecimal APPLE_COST = new BigDecimal("0.60");
    public static final BigDecimal ORANGE_COST = new BigDecimal("0.25");
    private CheckoutSystem checkoutSystem = new CheckoutSystem();
    private List<Item> items = new ArrayList<Item>();

    @Test
    public void totalCostTestForAnAppleAndAnOrange() {
        createGivenNumberOfApplesAndOrangesAndAddThemToItems(1,1);
        assertEquals(getExpectedResult(), checkoutSystem.totalCost(items));
    }

    private BigDecimal getExpectedResult() {
        BigDecimal expected = new BigDecimal("0.0");
        for (Item item: items) {
            expected = expected.add(item.getCost());
        }
        return expected;
    }

    public void createGivenNumberOfApplesAndOrangesAndAddThemToItems(int numberOfApples, int numberOfOrange){
        Item item = null;
        for (int i = 0; i < numberOfApples; i++) {
            item = new Apple(APPLE_COST);
            items.add(item);
        }
        for (int i = 0; i < numberOfOrange; i++) {
            item = new Orange(ORANGE_COST);
            items.add(item);
        }
    }

    @Test
    public void totalCostTestFor2ApplesAnd2Orange() {
        Item apple1 = new Apple(APPLE_COST);
        Item apple2 = new Apple(APPLE_COST);
        Item orange1 = new Orange(ORANGE_COST);
        Item orange2 = new Orange(ORANGE_COST);
        items = Arrays.asList(apple1, apple2, orange1, orange2);
        BigDecimal expected = apple1.getCost().add(apple2.getCost()).add(orange1.getCost()).add(orange2.getCost());
        assertEquals(expected, checkoutSystem.totalCost(items));
    }

    @Test
    public void totalCostTestFor3ApplesAnd1Orange() {
        Item apple1 = new Apple(APPLE_COST);
        Item apple2 = new Apple(APPLE_COST);
        Item apple3 = new Apple(APPLE_COST);
        Item orange1 = new Orange(ORANGE_COST);
        items = Arrays.asList(apple1, apple2, apple3, orange1);
        BigDecimal expected = apple1.getCost().add(apple2.getCost()).add(apple3.getCost()).add(orange1.getCost());
        assertEquals(expected, checkoutSystem.totalCost(items));
    }

}
