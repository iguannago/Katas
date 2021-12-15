package com.equalexpert.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProductTest {

    private final String someProduct = "some product";
    private final BigDecimal somePrice = new BigDecimal("0.00");

    private final String someOtherProduct = "some other product";
    private final BigDecimal someOtherPrice = new BigDecimal("0.01");

    private final Product product1 = new Product(someProduct, somePrice);
    private final Product product2 = new Product(someOtherProduct, someOtherPrice);

    @Test
    void getName() {
        Assertions.assertEquals(someProduct, product1.getName());
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(somePrice, product1.getPrice());
    }

    @Test
    void equals() {
        Assertions.assertNotEquals(product1, product2);
        Assertions.assertEquals(product1, product1);
        Assertions.assertNotEquals(product1, new Product(product1.getName(), product2.getPrice()));
    }

    @Test
    void hashCodeTest() {
        Assertions.assertNotEquals(product1.hashCode(), product2.hashCode());
        Assertions.assertEquals(product1.hashCode(), new Product(someProduct, somePrice).hashCode());
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals("Product{name='some product', price=0.00}", product1.toString());
    }
}