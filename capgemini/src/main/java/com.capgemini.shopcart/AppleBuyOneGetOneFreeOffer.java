package com.capgemini.shopcart;


import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public final class AppleBuyOneGetOneFreeOffer implements Offer {

    @Override
    public int getNumberOfFreeItems(List<? extends Item> items) {
        return getNumberOfItems(items) / 2;
    }

    @Override
    public boolean isEquals(Item item) {
        return item.getClass().equals(Apple.class);
    }
}
