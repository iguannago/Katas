package com.sky.basket;

import com.sky.customer.CustomerService;
import com.sky.subscription.SubscriptionNotFoundException;
import com.sky.subscription.SubscriptionService;

import java.math.BigDecimal;
import java.util.List;

public class BasketService {

    SubscriptionService subscriptionService;
    CustomerService customerService;

    public BasketService(SubscriptionService subscriptionService, CustomerService customerService) {
        this.subscriptionService = subscriptionService;
        this.customerService = customerService;
    }

    public BigDecimal calculate(String customerId, List<String> subscriptions) throws BasketConditionNotMetException {
        List<String> customerSubscriptions = customerService.getSubscriptionsForCustomer(customerId);
        if (subscriptions.contains("BOOST") && !customerSubscriptions.contains("ENTERTAINMENT")) {
            throw new BasketConditionNotMetException();
        } else {
            return calculateSubsCosts(subscriptions);
        }
    }

    private BigDecimal calculateSubsCosts(List<String> subscriptions) {
        return subscriptions.stream()
                .map(this::getStringBigDecimalFunction)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

    private BigDecimal getStringBigDecimalFunction(String sub) {
        BigDecimal cost = subscriptionService.getSubscriptionPrice(sub);
        if (cost == null) {
            throw new SubscriptionNotFoundException();
        }
        return cost;
    }
}
