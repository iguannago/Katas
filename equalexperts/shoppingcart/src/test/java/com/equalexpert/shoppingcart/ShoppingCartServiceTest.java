package com.equalexpert.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceTest {

    private final ShoppingCartService shoppingCartService = new ShoppingCartService();
    private final Product doveSoap = new Product("Dove soap", new BigDecimal("39.99"));

    @Test
    void given_empty_shopping_cart_when_user_adds_five_product_then_shopping_cart_is_as_expected() {
        ShoppingCart emptyShoppingCart = new ShoppingCart(new ArrayList<>(), new BigDecimal("0.00"));

        ShoppingCart actualShoppingCart = shoppingCartService.addProductGivenUnits(emptyShoppingCart, doveSoap, 5);

        Assertions.assertEquals(5, actualShoppingCart.getProducts().size());
        Assertions.assertEquals(5,
            getCountOfProductsWithGivenUnitPrice(actualShoppingCart.getProducts(), "39.99"));
        Assertions.assertEquals("199.95", actualShoppingCart.getTotalPrice().toString());
    }

    private long getCountOfProductsWithGivenUnitPrice(List<Product> products, String unitPrice) {
        return products.stream()
            .filter(p -> p.getPrice().equals(new BigDecimal(unitPrice)))
            .count();
    }

    // edge case scenarios

    @Test
    void given_null_shopping_cart_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> shoppingCartService.addProductGivenUnits(null, doveSoap, 1));

        Assertions.assertEquals("Error: shopping cart is null", actualException.getMessage());
    }

    @Test
    void given_product_list_is_null_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> {
                ShoppingCart shoppingCartWithNullProductList =
                    new ShoppingCart(null, new BigDecimal("0.00"));
                shoppingCartService.addProductGivenUnits(shoppingCartWithNullProductList, doveSoap, 1);
            });

        Assertions.assertEquals("Error: product list is null", actualException.getMessage());
    }

    @Test
    void given_unit_is_zero_or_negative_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> {
                ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(), new BigDecimal("0.00"));
                shoppingCartService.addProductGivenUnits(shoppingCart, doveSoap, 0);
            });

        Assertions.assertEquals("Error: units has to be a positive number", actualException.getMessage());
    }

    @Test
    void given_totalPrice_is_zero_or_negative_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> {
                ShoppingCart shoppingCartWithInvalidTotalPrice =
                    new ShoppingCart(new ArrayList<>(), new BigDecimal("-1.00"));
                shoppingCartService.addProductGivenUnits(shoppingCartWithInvalidTotalPrice, doveSoap, 1);
            });

        Assertions.assertEquals("Error: invalid total price", actualException.getMessage());
    }

    @Test
    void given_newProduct_is_null_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> shoppingCartService.addProductGivenUnits(
                new ShoppingCart(new ArrayList<>(), new BigDecimal("0.00")),
                null,
                1));

        Assertions.assertEquals("Error: new product is null", actualException.getMessage());
    }

    @Test
    void given_empty_shopping_cart_when_adding_additional_same_products_then_shopping_cart_is_as_expected() {
        ShoppingCart emptyShoppingCart = new ShoppingCart(new ArrayList<>(), new BigDecimal("0.00"));

        ShoppingCart shoppingCartWithFiveProducts =
            shoppingCartService.addProductGivenUnits(emptyShoppingCart, doveSoap, 5);
        ShoppingCart actualShoppingCart =
            shoppingCartService.addProductGivenUnits(shoppingCartWithFiveProducts, doveSoap, 3);

        Assertions.assertEquals(8, actualShoppingCart.getProducts().size());
        Assertions.assertEquals(8,
            getCountOfProductsWithGivenUnitPrice(actualShoppingCart.getProducts(), "39.99"));
        Assertions.assertEquals("319.92", actualShoppingCart.getTotalPrice().toString());
    }
}
