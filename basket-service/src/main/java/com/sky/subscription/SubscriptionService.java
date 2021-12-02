package com.sky.subscription;

import java.math.BigDecimal;

public interface SubscriptionService {
    BigDecimal getSubscriptionPrice(String subscription);
}
