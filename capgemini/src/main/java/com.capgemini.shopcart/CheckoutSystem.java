package com.capgemini.shopcart;



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
        List<? extends Item> itemsWithOfferApplied = applyOffers(items);
        for (Item item: itemsWithOfferApplied) {
            totalCost = totalCost.add(item.getCost());
        }
        return totalCost;
    }

    private List<? extends Item> applyOffers(List<? extends Item> items) {
        List<? extends Item> itemsWithOffersApplied = items;
        for (Offer offer: offers) {
            offer.apply(itemsWithOffersApplied);
        }
        return itemsWithOffersApplied;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
