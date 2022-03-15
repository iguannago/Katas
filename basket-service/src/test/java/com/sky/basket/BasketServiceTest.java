package com.sky.basket;

import com.sky.customer.CustomerService;
import com.sky.subscription.SubscriptionNotFoundException;
import com.sky.subscription.SubscriptionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {

    public static final String ENTERTAINMENT = "ENTERTAINMENT";
    public static final String SPORTS = "SPORTS";
    public static final String CUSTOMER_ID = "1";
    private static final String MOVIES = "MOVIES";
    private static final String BOOST = "BOOST";
    private static final String HALF_PRICE = "HALF_PRICE";
    private static final String TEN_PERCENT = "TEN_PERCENT";
    @Mock
    SubscriptionService subscriptionService;
    @Mock
    CustomerService customerService;
    @InjectMocks
    private BasketService basketService;

    @Before
    public void setUp() {
        when(subscriptionService.getSubscriptionPrice(ENTERTAINMENT)).thenReturn(new BigDecimal("9.99"));
        when(subscriptionService.getSubscriptionPrice(SPORTS)).thenReturn(new BigDecimal("19.99"));
        when(subscriptionService.getSubscriptionPrice(BOOST)).thenReturn(new BigDecimal("1.99"));
    }

    //Part 1 - Implement Basket Service:

    /**
     * Scenario: Successful basket calculation of a single subscription
     * Given the customer wants to purchase an ENTERTAINMENT subscription
     * When the basket is calculated
     * Then a successful response is returned with £9.99 as the charge
     */
    @Test
    public void given_entertainment_subs_when_basket_calculates_cost_then_returns_9_99() {
        BigDecimal actualCost = basketService.calculate(CUSTOMER_ID, List.of(ENTERTAINMENT), null);

        assertEquals(new BigDecimal("9.99"), actualCost);
        verify(subscriptionService).getSubscriptionPrice(ENTERTAINMENT);
    }

    @Test
    public void given_sports_subs_when_basket_calculates_cost_then_returns_19_99() {
        BigDecimal actualCost = basketService.calculate(CUSTOMER_ID, List.of(SPORTS), null);

        assertEquals(new BigDecimal("19.99"), actualCost);
        verify(subscriptionService).getSubscriptionPrice(SPORTS);
    }

    /**
     * Scenario: Unknown subscription should return SubscriptionNotFound exception
     * Given the customer wants to purchase a MOVIES subscription
     * And the SubscriptionService does not return a price (returns null)
     * When the basket is calculated
     * Then a SubscriptionNotFound exception is thrown
     */
    @Test(expected = SubscriptionNotFoundException.class)
    public void given_unknown_sub_when_calculate_then_throw_exception() {
        basketService.calculate(CUSTOMER_ID, List.of(MOVIES), null);

        verify(subscriptionService).getSubscriptionPrice(MOVIES);
    }

    /**
     * Scenario: Successful basket calculation of multiple subscriptions
     * Given the customer wants to purchase ENTERTAINMENT and SPORTS subscriptions
     * When the basket is calculated
     * Then a successful response is returned with £29.98 as the charge
     */
    @Test
    public void give_multiple_subs_then_returns_expected_cost() {
        BigDecimal actualCost = basketService.calculate("1", List.of(ENTERTAINMENT, SPORTS), null);

        assertEquals(new BigDecimal("29.98"), actualCost);
        InOrder inOrder = inOrder(subscriptionService);
        inOrder.verify(subscriptionService).getSubscriptionPrice(ENTERTAINMENT);
        inOrder.verify(subscriptionService).getSubscriptionPrice(SPORTS);
    }

    // Part 2 - Enhance Basket Service to use Customer Service

    /**
     * Scenario: Successful basket calculation of a BOOST subscription
     * Given the customer has an existing ENTERTAINMENT subscription
     * And the customer wants to purchase a BOOST subscription
     * When the basket is calculated
     * Then a successful response is returned with £1.99 as the charge
     */
    @Test
    public void given_boost_subs_and_entertainment_then_returns_expected_cost() {
        when(customerService.getSubscriptionsForCustomer(CUSTOMER_ID)).thenReturn(List.of(ENTERTAINMENT));

        BigDecimal actualCost = basketService.calculate(CUSTOMER_ID, List.of(BOOST), null);

        assertEquals(new BigDecimal("1.99"), actualCost);
        verify(customerService).getSubscriptionsForCustomer(CUSTOMER_ID);
        verify(subscriptionService).getSubscriptionPrice(BOOST);
    }

    @Test(expected = BasketConditionNotMetException.class)
    public void given_boost_subs_then_expects_exception() {
        when(customerService.getSubscriptionsForCustomer(CUSTOMER_ID)).thenReturn(null);

        basketService.calculate(CUSTOMER_ID, List.of(BOOST), null);

        verify(subscriptionService).getSubscriptionPrice(SPORTS);
        verify(customerService).getSubscriptionsForCustomer(CUSTOMER_ID);
    }

    @Test(expected = BasketConditionNotMetException.class)
    public void given_boost_subs_when_customer_has_empty_subs_then_expects_exception() {
        when(customerService.getSubscriptionsForCustomer(CUSTOMER_ID)).thenReturn(Collections.emptyList());

        basketService.calculate(CUSTOMER_ID, List.of(BOOST), null);

        verify(subscriptionService).getSubscriptionPrice(SPORTS);
        verify(customerService).getSubscriptionsForCustomer(CUSTOMER_ID);
    }

    @Test
    public void given_boost1_subs_then_returns_expected_cost() {
        when(subscriptionService.getSubscriptionPrice("BOOST1")).thenReturn(new BigDecimal("2.99"));

        BigDecimal actualCost = basketService.calculate("1", List.of("BOOST1"), null);

        assertEquals(new BigDecimal("2.99"), actualCost);
    }

    // Part 3 - Enhance Basket Service to use Vouchers

    /**
     * Scenario: Successful basket calculation with a voucher
     * Given the customer wants to purchase an ENTERTAINMENT subscription
     * And the customer applies a HALF_PRICE voucher
     * When the basket is calculated
     * Then a successful response is returned with £4.99 as the charge
     */
    @Test
    public void given_customer_purchases_entertainment_and_has_half_price_voucher_when_calculate_then_expect_4_99() {
        BigDecimal actualCost = basketService.calculate(CUSTOMER_ID, List.of(ENTERTAINMENT), HALF_PRICE);

        assertEquals(new BigDecimal("4.99"), actualCost);

        verify(subscriptionService).getSubscriptionPrice(ENTERTAINMENT);
    }

    @Test
    public void given_customer_purchases_entertainment_and_has_ten_percent_voucher_when_calculate_then_expect_9() {
        BigDecimal actualCost = basketService.calculate(CUSTOMER_ID, List.of(ENTERTAINMENT), TEN_PERCENT);

        assertEquals(new BigDecimal("9.00"), actualCost);

        verify(subscriptionService).getSubscriptionPrice(ENTERTAINMENT);
    }

}