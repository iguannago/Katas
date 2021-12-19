package com.equalexpert.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class ShoppingCartTest {

    private final Product someProduct = new Product("some product", new BigDecimal("0.00"));
    private final Product someOtherProduct = new Product("some other product", new BigDecimal("1.00"));
    private final ShoppingCart shoppingCartWithSomeOtherProduct = new ShoppingCart(
        List.of(someOtherProduct),
        new BigDecimal("0.00"),
        new BigDecimal("0.00"), new BigDecimal("0.00"),
        new BigDecimal("0.00"));

    private final ShoppingCart shoppingCartWithSomeProduct = new ShoppingCart(
        List.of(someProduct),
        new BigDecimal("0.00"),
        new BigDecimal("0.00"), new BigDecimal("0.00"),
        new BigDecimal("0.00"));

    @Test
    void getProducts() {
        Assertions.assertEquals(List.of(someProduct), shoppingCartWithSomeProduct.getProducts());
    }

    @Test
    void getTotalPrice() {
        Assertions.assertEquals(new BigDecimal("0.00"), shoppingCartWithSomeProduct.getTotalPrice());
    }

    @Test
    void hashCodeTest() {
        Assertions.assertEquals(
            shoppingCartWithSomeProduct.hashCode(),
            new ShoppingCart(List.of(someProduct),
                new BigDecimal("0.00"),
                new BigDecimal("0.00"),
                new BigDecimal("0.00"),
                new BigDecimal("0.00")).hashCode()
        );

        Assertions.assertNotEquals(shoppingCartWithSomeProduct, shoppingCartWithSomeOtherProduct);
    }

    @Test
    void equalsTest() {
        Assertions.assertNotEquals(shoppingCartWithSomeProduct, shoppingCartWithSomeOtherProduct);
        Assertions.assertEquals(
            shoppingCartWithSomeProduct,
            new ShoppingCart(List.of(someProduct),
                new BigDecimal("0.00"),
                new BigDecimal("0.00"),
                new BigDecimal("0.00"),
                new BigDecimal("0.00"))
        );
    }

    @Test
    void toStringTest() {
        Assertions.assertEquals(
            "ShoppingCart{products=[Product{name='some product', price=0.00}], totalPrice=0.00, "
            + "totalPriceWithSalesTax=0.00, salesTaxRate=0.00, totalSalesTax=0.00}",
            shoppingCartWithSomeProduct.toString()
        );
    }
}