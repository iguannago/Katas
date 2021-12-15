package com.equalexpert.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class ShoppingCartTest {

    private final List<Product> products = List.of(new Product("some product", new BigDecimal("0.00")));
    private final ShoppingCart shoppingCart = new ShoppingCart(products, new BigDecimal("0.00"));

    @Test
    void getProducts() {
        Assertions.assertEquals(products, shoppingCart.getProducts());
    }

    @Test
    void getTotalPrice() {
        Assertions.assertEquals(new BigDecimal("0.00"), shoppingCart.getTotalPrice());
    }

    //todo: add equals, hashCode and toString tests (MUST)
}