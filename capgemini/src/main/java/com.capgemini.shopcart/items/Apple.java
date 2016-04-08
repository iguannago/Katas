package com.capgemini.shopcart.items;

import java.math.BigDecimal;

/**
 * Created by davicres on 08/04/2016.
 */
public final class Apple extends Item {
    public Apple(BigDecimal cost) {
        super(cost);
    }

    @Override
    public String toString() {
        return "Apple{}";
    }
}
