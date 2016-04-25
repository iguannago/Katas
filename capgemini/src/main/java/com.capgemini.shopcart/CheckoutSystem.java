package com.capgemini.shopcart;



import com.capgemini.shopcart.items.Item;
import com.capgemini.shopcart.offers.Offer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public final class CheckoutSystem {
    private List<Offer> offers = new ArrayList<Offer>();

    public BigDecimal totalCost(final List<? extends Item> items) {
        BigDecimal totalCost = new BigDecimal("0.00");
        applyOffers(items);
        for (Item item: items) {
            totalCost = totalCost.add(item.getCost());
        }
        return totalCost;
    }

    private void applyOffers(List<? extends Item> items) {
        for (Offer offer: offers) {
            offer.apply(items);
        }
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
