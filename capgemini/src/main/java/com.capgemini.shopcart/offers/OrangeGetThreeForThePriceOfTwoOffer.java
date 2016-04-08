package com.capgemini.shopcart.offers;


import com.capgemini.shopcart.items.Item;
import com.capgemini.shopcart.items.Orange;

import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public final class OrangeGetThreeForThePriceOfTwoOffer implements Offer {
    @Override
    public int getNumberOfFreeItems(List<? extends Item> items) {
        return getNumberOfItems(items) / 3;
    }

    @Override
    public boolean isEquals(Item item) {
        return item.getClass().equals(Orange.class);
    }

}
