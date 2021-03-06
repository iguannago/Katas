package com.capgemini.shopcart;

import com.capgemini.shopcart.items.Apple;
import com.capgemini.shopcart.items.Item;
import com.capgemini.shopcart.items.Orange;
import com.capgemini.shopcart.offers.AppleBuyOneGetOneFreeOffer;
import com.capgemini.shopcart.offers.Offer;
import com.capgemini.shopcart.offers.OrangeGetThreeForThePriceOfTwoOffer;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 08/04/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class CheckoutSystemTest {
    public static final BigDecimal APPLE_COST = new BigDecimal("0.60");
    public static final BigDecimal ORANGE_COST = new BigDecimal("0.25");
    private CheckoutSystem checkoutSystem = new CheckoutSystem();
    private List<Item> items = new ArrayList<>();

    @Test
    @Parameters(method = "getAmountOfApplesAndOranges")
    public void totalCostTestForApplesAndAnOrangesInTheList(int amountOfApples, int amountOfOranges) {
        createGivenNumberOfApplesAndOrangesAndAddThemToItems(amountOfApples,amountOfOranges);
        BigDecimal expectedResult = getExpectedResult();
        assertEquals(expectedResult, checkoutSystem.totalCost(items));
    }


    private BigDecimal getExpectedResult() {
        BigDecimal expected = new BigDecimal("0.00");
        for (Item item: items) {
            expected = expected.add(item.getCost());
        }
        return expected;
    }

    private void createGivenNumberOfApplesAndOrangesAndAddThemToItems(int numberOfApples, int numberOfOrange){
        Item item;
        for (int i = 0; i < numberOfApples; i++) {
            item = new Apple(APPLE_COST);
            items.add(item);
        }
        for (int i = 0; i < numberOfOrange; i++) {
            item = new Orange(ORANGE_COST);
            items.add(item);
        }
    }

    @Test
    @Parameters(method = "getAmountOfApplesAndOranges")
    public void totalCostAppliesAppleOfferTest(int amountOfApples, int amountOfOranges) {
        createGivenNumberOfApplesAndOrangesAndAddThemToItems(amountOfApples, amountOfOranges);
        BigDecimal expected = APPLE_COST.multiply(BigDecimal.valueOf(amountOfApples - (amountOfApples/2))).
                add(ORANGE_COST.multiply(BigDecimal.valueOf(amountOfOranges)));
        checkoutSystem.setOffers(Arrays.<Offer>asList(new AppleBuyOneGetOneFreeOffer()));
        assertEquals(expected, checkoutSystem.totalCost(items));
    }


    @Test
    @Parameters(method = "getAmountOfApplesAndOranges")
    public void totalCostAppliesOrangeOfferTest(int amountOfApples, int amountOfOranges) {
        createGivenNumberOfApplesAndOrangesAndAddThemToItems(amountOfApples, amountOfOranges);
        BigDecimal expected = ORANGE_COST.multiply(BigDecimal.valueOf(amountOfOranges - (amountOfOranges/3))).
                add(APPLE_COST.multiply(BigDecimal.valueOf(amountOfApples)));
        checkoutSystem.setOffers(Arrays.<Offer>asList(new OrangeGetThreeForThePriceOfTwoOffer()));
        assertEquals(expected, checkoutSystem.totalCost(items));
    }

    private static final Object[] getAmountOfApplesAndOranges() {
        return new Integer[][]{
                {1,1}, {2,2}, {3,1}, {4,5}, {0,0}, {10, 20}, {3,4}, {10,0}, {0,10}, {7,9}
        };
    }
}
