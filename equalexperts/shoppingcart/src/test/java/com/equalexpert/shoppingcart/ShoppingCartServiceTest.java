package com.equalexpert.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingCartServiceTest {

    @Test
    void given_empty_shopping_cart_when_user_adds_five_product_then_shopping_cart_is_as_expected() {
        ShoppingCartService shoppingCartService = new ShoppingCartService();

        ShoppingCart emptyShoppingCart = new ShoppingCart(new ArrayList<>(), new BigDecimal("0.00"));
        Product doveSoap = new Product("Dove soap", new BigDecimal("39.99"));

        ShoppingCart actualShoppingCart = shoppingCartService.addProduct(emptyShoppingCart, doveSoap, 5);

        Assertions.assertEquals(5, actualShoppingCart.getProducts().size());
        Assertions.assertEquals("199.95", actualShoppingCart.getTotalPrice().toString());
    }
}
