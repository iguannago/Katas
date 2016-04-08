package com.capgemini.shopcart;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public final class CheckoutSystem {
    public BigDecimal totalCost(final List<? extends Item> items) {
        BigDecimal totalCost = new BigDecimal("0");
        for (Item item: items) {
            totalCost = totalCost.add(item.getCost());
        }
        return totalCost;
    }
}
