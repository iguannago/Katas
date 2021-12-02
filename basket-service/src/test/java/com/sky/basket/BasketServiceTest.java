package com.sky.basket;

import com.sky.customer.CustomerService;
import com.sky.subscription.SubscriptionNotFoundException;
import com.sky.subscription.SubscriptionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {

    @Mock
    SubscriptionService subscriptionService;
    @Mock
    CustomerService customerService;
    @InjectMocks
    private BasketService basketService;

    /*
    Scenario: Successful basket calculation of a single subscription
Given the customer wants to purchase an ENTERTAINMENT subscription
When the basket is calculated
Then a successful response is returned with £9.99 as the charge
     */

    @Test
    public void given_entertainment_subs_when_basket_calculates_cost_then_returns_9_99() {
        Mockito.when(subscriptionService.getSubscriptionPrice("ENTERTAINMENT")).thenReturn(new BigDecimal("9.99"));

        List<String> entertainmentSubs = List.of("ENTERTAINMENT");
        BigDecimal actualCost = basketService.calculate("1", entertainmentSubs);

        Assert.assertEquals(new BigDecimal("9.99"), actualCost);
    }

    @Test
    public void given_sports_subs_when_basket_calculates_cost_then_returns_19_99() {
        Mockito.when(subscriptionService.getSubscriptionPrice("SPORTS")).thenReturn(new BigDecimal("19.99"));

        List<String> entertainmentSubs = List.of("SPORTS");
        BigDecimal actualCost = basketService.calculate("1", entertainmentSubs);

        Assert.assertEquals(new BigDecimal("19.99"), actualCost);
    }


    /*
    Scenario: Successful basket calculation of multiple subscriptions
Given the customer wants to purchase ENTERTAINMENT and SPORTS subscriptions
When the basket is calculated
Then a successful response is returned with £29.98 as the charge
     */

    @Test
    public void give_multiple_subs_then_returns_expected_cost() {
        List<String> subscriptions = List.of("ENTERTAINMENT", "SPORTS");

        Mockito.when(subscriptionService.getSubscriptionPrice("ENTERTAINMENT")).thenReturn(new BigDecimal("9.99"));
        Mockito.when(subscriptionService.getSubscriptionPrice("SPORTS")).thenReturn(new BigDecimal("19.99"));

        BigDecimal actualCost = basketService.calculate("1", subscriptions);

        Assert.assertEquals(new BigDecimal("29.98"), actualCost);
    }


    /*
    Scenario: Unknown subscription should return SubscriptionNotFound exception
Given the customer wants to purchase a MOVIES subscription
And the SubscriptionService does not return a price (returns null)
When the basket is calculated
Then a SubscriptionNotFound exception is thrown
     */

    @Test(expected = SubscriptionNotFoundException.class)
    public void given_unknown_subscription_returns_exception() {
        Mockito.when(subscriptionService.getSubscriptionPrice("MOVIES")).thenReturn(null);

        basketService.calculate("1", List.of("MOVIES"));
    }


    /*
    Scenario: Successful basket calculation of a BOOST subscription
    Given the customer has an existing ENTERTAINMENT subscription
    And the customer wants to purchase a BOOST subscription
    When the basket is calculated
    Then a successful response is returned with £1.99 as the charge
     */

    @Test
    public void given_boost_subs_then_returns_expected_cost() {
        Mockito.when(customerService.getSubscriptionsForCustomer(anyString())).thenReturn(List.of("ENTERTAINMENT"));
        Mockito.when(subscriptionService.getSubscriptionPrice("BOOST")).thenReturn(new BigDecimal("1.99"));

        BigDecimal actualCost = basketService.calculate("1", List.of("BOOST"));

        Assert.assertEquals(new BigDecimal("1.99"), actualCost);
    }

    @Test(expected = BasketConditionNotMetException.class)
    public void given_boost_subs_then_expects_exception() {
        Mockito.when(customerService.getSubscriptionsForCustomer(anyString())).thenReturn(List.of("SPORTS"));

        basketService.calculate("1", List.of("BOOST"));
    }


    @Test
    public void given_boost1_subs_then_returns_expected_cost() {
        Mockito.when(customerService.getSubscriptionsForCustomer(anyString())).thenReturn(List.of("ENTERTAINMENT"));
        Mockito.when(subscriptionService.getSubscriptionPrice("BOOST1")).thenReturn(new BigDecimal("2.99"));

        BigDecimal actualCost = basketService.calculate("1", List.of("BOOST1"));

        Assert.assertEquals(new BigDecimal("2.99"), actualCost);
    }
}