package com.capgemini.shopcart.offers;

import com.capgemini.shopcart.items.Item;

import java.util.Iterator;
import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public interface Offer {
    default void apply(List<? extends Item> items) {
        removeFreeItemsFromTheItemsList(items, getNumberOfFreeItems(items));
    }


    default void removeFreeItemsFromTheItemsList(List<? extends Item> items, int freeItems) {
        Iterator<? extends Item> iter = items.iterator();
        while (iter.hasNext() && freeItems != 0) {
            Item item = iter.next();
            if (isEquals(item)) {
                iter.remove();
                freeItems--;
            }
        }
    }

    default int getNumberOfItems(List<? extends Item> items) {
        int count = 0;
        for (Item item : items) {
            if (isEquals(item)) {
                count++;
            }
        }
        return count;

    }

    int getNumberOfFreeItems(List<? extends Item> items);
    boolean isEquals(Item item);
}
