package com.capgemini.shopcart;

import java.util.List;

/**
 * Created by davicres on 08/04/2016.
 */
public interface AppleOffer {
    List<? extends Item> apply(List<? extends Item> items);
}
