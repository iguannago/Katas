package com.sky.basket;

import com.sky.customer.CustomerService;
import com.sky.subscription.SubscriptionNotFoundException;
import com.sky.subscription.SubscriptionService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BasketService {

    public static final String BOOST = "BOOST";
    public static final String HALF_PRICE = "HALF_PRICE";
    private static final String TEN_PERCENT = "TEN_PERCENT";
    SubscriptionService subscriptionService;
    CustomerService customerService;

    public BasketService(SubscriptionService subscriptionService, CustomerService customerService) {
        this.subscriptionService = subscriptionService;
        this.customerService = customerService;
    }

    public BigDecimal calculate(String customerId, List<String> subscriptions, String voucher)
            throws BasketConditionNotMetException {
        checkBoostSubscriptionScenario(customerId, subscriptions);
        return calculateSubsCosts(subscriptions, voucher);
    }

    private void checkBoostSubscriptionScenario(String customerId, List<String> subscriptions) {
        if (subscriptions.contains(BOOST)) {
            List<String> customerSubscriptions = customerService.getSubscriptionsForCustomer(customerId);
            if (Objects.isNull(customerSubscriptions) || customerSubscriptions.isEmpty()) {
                throw new BasketConditionNotMetException();
            }
        }
    }

    private BigDecimal calculateSubsCosts(List<String> subscriptions, String voucher) {
        BigDecimal costBeforeVoucher = calculateCostBeforeVoucher(subscriptions);
        Optional<String> validVoucher = Optional.ofNullable(voucher);
        if (validVoucher.isPresent()) {
            return applyVoucher(costBeforeVoucher, validVoucher.get());
        }
        return costBeforeVoucher;
    }

    private BigDecimal applyVoucher(BigDecimal costBeforeVoucher, String voucher) {
        if (HALF_PRICE.equals(voucher)) {
            return costBeforeVoucher.divide(new BigDecimal(2), RoundingMode.DOWN);
        }
        if (TEN_PERCENT.equals(voucher)) {
            return costBeforeVoucher.subtract(costBeforeVoucher.divide(new BigDecimal("10"), RoundingMode.DOWN));
        }
        return costBeforeVoucher;
    }

    private BigDecimal calculateCostBeforeVoucher(List<String> subscriptions) {
        return subscriptions.stream()
                .map(sub -> Optional.ofNullable(subscriptionService.getSubscriptionPrice(sub))
                        .orElseThrow(SubscriptionNotFoundException::new))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }

}
