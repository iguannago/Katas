package com.sky.basket;

import com.sky.customer.CustomerService;
import com.sky.subscription.SubscriptionNotFoundException;
import com.sky.subscription.SubscriptionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {

    public static final String ENTERTAINMENT = "ENTERTAINMENT";
    public static final String SPORTS = "SPORTS";
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
    }

    /**
     * Scenario: Successful basket calculation of a single subscription
     * Given the customer wants to purchase an ENTERTAINMENT subscription
     * When the basket is calculated
     * Then a successful response is returned with £9.99 as the charge
     */
    @Test
    public void given_entertainment_subs_when_basket_calculates_cost_then_returns_9_99() {
        BigDecimal actualCost = basketService.calculate("1", List.of(ENTERTAINMENT));

        assertEquals(new BigDecimal("9.99"), actualCost);
        verify(subscriptionService).getSubscriptionPrice(ENTERTAINMENT);
    }

    @Test
    public void given_sports_subs_when_basket_calculates_cost_then_returns_19_99() {
        BigDecimal actualCost = basketService.calculate("1", List.of(SPORTS));

        assertEquals(new BigDecimal("19.99"), actualCost);
        verify(subscriptionService).getSubscriptionPrice(SPORTS);
    }

    /**
     * Scenario: Successful basket calculation of multiple subscriptions
     * Given the customer wants to purchase ENTERTAINMENT and SPORTS subscriptions
     * When the basket is calculated
     * Then a successful response is returned with £29.98 as the charge
     */
    @Test
    public void give_multiple_subs_then_returns_expected_cost() {
        List<String> subscriptions = List.of("ENTERTAINMENT", "SPORTS");

        when(subscriptionService.getSubscriptionPrice("ENTERTAINMENT")).thenReturn(new BigDecimal("9.99"));
        when(subscriptionService.getSubscriptionPrice("SPORTS")).thenReturn(new BigDecimal("19.99"));

        BigDecimal actualCost = basketService.calculate("1", subscriptions);

        assertEquals(new BigDecimal("29.98"), actualCost);
    }


    /**
     * Scenario: Unknown subscription should return SubscriptionNotFound exception
     * Given the customer wants to purchase a MOVIES subscription
     * And the SubscriptionService does not return a price (returns null)
     * When the basket is calculated
     * Then a SubscriptionNotFound exception is thrown
     */
    @Test(expected = SubscriptionNotFoundException.class)
    public void given_unknown_subscription_returns_exception() {
        when(subscriptionService.getSubscriptionPrice("MOVIES")).thenReturn(null);

        basketService.calculate("1", List.of("MOVIES"));
    }


    /**
     * Scenario: Successful basket calculation of a BOOST subscription
     * Given the customer has an existing ENTERTAINMENT subscription
     * And the customer wants to purchase a BOOST subscription
     * When the basket is calculated
     * Then a successful response is returned with £1.99 as the charge
     */

    @Test
    public void given_boost_subs_then_returns_expected_cost() {
        when(customerService.getSubscriptionsForCustomer(anyString())).thenReturn(List.of("ENTERTAINMENT"));
        when(subscriptionService.getSubscriptionPrice("BOOST")).thenReturn(new BigDecimal("1.99"));

        BigDecimal actualCost = basketService.calculate("1", List.of("BOOST"));

        assertEquals(new BigDecimal("1.99"), actualCost);
    }

    @Test(expected = BasketConditionNotMetException.class)
    public void given_boost_subs_then_expects_exception() {
        when(customerService.getSubscriptionsForCustomer(anyString())).thenReturn(List.of("SPORTS"));

        basketService.calculate("1", List.of("BOOST"));
    }


    @Test
    public void given_boost1_subs_then_returns_expected_cost() {
        when(customerService.getSubscriptionsForCustomer(anyString())).thenReturn(List.of("ENTERTAINMENT"));
        when(subscriptionService.getSubscriptionPrice("BOOST1")).thenReturn(new BigDecimal("2.99"));

        BigDecimal actualCost = basketService.calculate("1", List.of("BOOST1"));

        assertEquals(new BigDecimal("2.99"), actualCost);
    }
}