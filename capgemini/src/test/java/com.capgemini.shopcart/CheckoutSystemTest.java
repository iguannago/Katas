package com.capgemini.shopcart;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 08/04/2016.
 */
public class CheckoutSystemTest {
    @Test
    public void totalCost(){
        CheckoutSystem checkoutSystem = new CheckoutSystem();
        List<Item> items = new ArrayList<Item>();
        Item apple = new Apple(new BigDecimal("0.60"));
        Item orange = new Orange(new BigDecimal("0.25"));
        items.add(apple);
        items.add(orange);
        BigDecimal expected = apple.getCost().add(orange.getCost());
        System.out.println("expected: "  + expected);
        assertEquals(expected, checkoutSystem.totalCost(items));
    }
}
