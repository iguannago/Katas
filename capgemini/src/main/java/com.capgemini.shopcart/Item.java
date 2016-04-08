package com.capgemini.shopcart;

import java.math.BigDecimal;

/**
 * Created by davicres on 08/04/2016.
 */
public class Item {
    private BigDecimal cost;

    public Item(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
