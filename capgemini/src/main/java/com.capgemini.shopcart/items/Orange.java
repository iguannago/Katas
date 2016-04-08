package com.capgemini.shopcart.items;

import java.math.BigDecimal;

/**
 * Created by davicres on 08/04/2016.
 */
public final class Orange extends Item {
    public Orange(BigDecimal cost) {
        super(cost);
    }

    @Override
    public String toString() {
        return "Orange{}";
    }
}
