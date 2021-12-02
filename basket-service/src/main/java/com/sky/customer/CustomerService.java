package com.sky.customer;

import java.util.List;

public interface CustomerService {
    List<String> getSubscriptionsForCustomer(String customerId);
}
