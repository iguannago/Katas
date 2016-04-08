package com.capgemini.shopcart;


import java.util.Iterator;
import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public final class AppleBuyOneGetOneFreeOffer implements Offer {

    public List<? extends Item> apply(List<? extends Item> items) {
        removeFreeApplesFromItems(items, getNumberOfFreeApples(items));
        return items;
    }

    private void removeFreeApplesFromItems(List<? extends Item> items, int freeApples) {
        Iterator<? extends Item> iter = items.iterator();
        while (iter.hasNext() && freeApples != 0) {
            Item item = iter.next();
            if (item.getClass().equals(Apple.class)) {
                iter.remove();
                freeApples--;
            }
        }
    }

    private int getNumberOfFreeApples(List<? extends Item> items) {
        return getNumberOfApples(items) / 2;
    }

    private int getNumberOfApples(List<? extends Item> items) {
        int count = 0;
        for (Item item : items) {
            if (item.getClass().equals(Apple.class)) {
                count++;
            }
        }
        return count;
    }
}
