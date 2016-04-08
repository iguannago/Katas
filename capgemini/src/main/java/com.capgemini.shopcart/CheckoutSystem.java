package com.capgemini.shopcart;



import java.math.BigDecimal;
import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public final class CheckoutSystem {
    private AppleOffer appleOffer;

    public BigDecimal totalCost(final List<? extends Item> items) {
        BigDecimal totalCost = new BigDecimal("0.00");
        List<? extends Item> itemsWithOfferApplied = applyAppleOffer(items);
        for (Item item: itemsWithOfferApplied) {
            totalCost = totalCost.add(item.getCost());
        }
        return totalCost;
    }

    private List<? extends Item> applyAppleOffer(List<? extends Item> items) {
        List<? extends Item> itemsWithOffersApplied = items;
        if (appleOffer != null) {
            itemsWithOffersApplied = appleOffer.apply(items);
        }
        return itemsWithOffersApplied;
    }

    public void setAppleOffer(AppleOffer appleOffer) {
        this.appleOffer = appleOffer;
    }

}
