package com.sky.basket;

import com.sky.customer.CustomerService;
import com.sky.subscription.SubscriptionNotFoundException;
import com.sky.subscription.SubscriptionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BasketService {

    public static final String BOOST = "BOOST";
    public static final String ENTERTAINMENT = "ENTERTAINMENT";
    SubscriptionService subscriptionService;
    CustomerService customerService;

    public BasketService(SubscriptionService subscriptionService, CustomerService customerService) {
        this.subscriptionService = subscriptionService;
        this.customerService = customerService;
    }

    public BigDecimal calculate(String customerId, List<String> subscriptions) throws BasketConditionNotMetException {
        if (subscriptions.contains(BOOST)) {
            List<String> customerSubscriptions = customerService.getSubscriptionsForCustomer(customerId);
            if (Objects.isNull(customerSubscriptions) || customerSubscriptions.isEmpty()) {
                throw new BasketConditionNotMetException();
            }
        }
        return calculateSubsCosts(subscriptions);
    }

    private BigDecimal calculateSubsCosts(List<String> subscriptions) {
        return subscriptions.stream()
                .map(sub -> Optional.ofNullable(subscriptionService.getSubscriptionPrice(sub))
                        .orElseThrow(SubscriptionNotFoundException::new))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

}
