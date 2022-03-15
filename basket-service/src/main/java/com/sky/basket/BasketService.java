package com.sky.basket;

import com.sky.customer.CustomerService;
import com.sky.subscription.SubscriptionNotFoundException;
import com.sky.subscription.SubscriptionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
                .map(sub -> Optional.ofNullable(subscriptionService.getSubscriptionPrice(sub))
                        .orElseThrow(SubscriptionNotFoundException::new))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

}
