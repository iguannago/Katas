package com.capgemini.shopcart;

import java.util.Iterator;
import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public final class OrangeGetThreeForThePriceOfTwoOffer implements Offer {
    public List<? extends Item> apply(List<? extends Item> items) {
        removeFreeOrangesFromItems(items, getNumberOfOrangesFree(items));
        return items;
    }

    private void removeFreeOrangesFromItems(List<? extends Item> items, int freeOranges) {
        Iterator<? extends Item> iter = items.iterator();
        while (iter.hasNext() && freeOranges != 0) {
            Item item = iter.next();
            if (item.getClass().equals(Orange.class)) {
                iter.remove();
                freeOranges--;
            }
        }
    }

    private int getNumberOfOrangesFree(List<? extends Item> items) {
        return getNumberOfOranges(items) / 3;
    }

    private int getNumberOfOranges(List<? extends Item> items) {
        int count = 0;
        for (Item item : items) {
            if (item.getClass().equals(Orange.class)) {
                count++;
            }
        }
        return count;
    }
}
