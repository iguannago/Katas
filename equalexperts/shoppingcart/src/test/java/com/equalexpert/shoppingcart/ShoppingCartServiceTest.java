package com.equalexpert.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceTest {

    private final ShoppingCartService shoppingCartService = new ShoppingCartService();
    private final Product doveSoapProduct = new Product("Dove soap", new BigDecimal("39.99"));
    private final ShoppingCart emptyShoppingCart = new ShoppingCart(new ArrayList<>(),
        new BigDecimal("0.00"),
        new BigDecimal("0.00"), new BigDecimal("0.00"),
        new BigDecimal("0.00"));

    @Test
    void given_empty_shopping_cart_when_user_adds_five_product_then_shopping_cart_is_as_expected() {
        ShoppingCart actualShoppingCart = shoppingCartService.addProductToShoppingCartGivenUnits(emptyShoppingCart,
            doveSoapProduct,
            5);

        Assertions.assertEquals(5, actualShoppingCart.getProducts().size());
        Assertions.assertEquals(5, getCountOfProductsForGivenProduct(actualShoppingCart.getProducts(),
            doveSoapProduct));
        Assertions.assertEquals("199.95", actualShoppingCart.getTotalPriceWithTax().toString());
    }

    private long getCountOfProductsForGivenProduct(List<Product> products, Product product) {
        return products.stream()
            .filter(p -> p.equals(product))
            .count();
    }

    // edge case scenarios

    @Test
    void given_null_shopping_cart_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> shoppingCartService.addProductToShoppingCartGivenUnits(null, doveSoapProduct, 1));

        Assertions.assertEquals("Error: shopping cart is null", actualException.getMessage());
    }

    @Test
    void given_product_list_is_null_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> {
                ShoppingCart shoppingCartWithNullProductList = new ShoppingCart(null,
                    new BigDecimal("0.00"),
                    new BigDecimal("0.00"), new BigDecimal("0.00"),
                    new BigDecimal("0.00"));
                shoppingCartService.addProductToShoppingCartGivenUnits(shoppingCartWithNullProductList, doveSoapProduct, 1);
            });

        Assertions.assertEquals("Error: product list is null", actualException.getMessage());
    }

    @Test
    void given_unit_is_zero_or_negative_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> {
                ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>(),
                    new BigDecimal("0.00"),
                    new BigDecimal("0.00"), new BigDecimal("0.00"),
                    new BigDecimal("0.00"));
                shoppingCartService.addProductToShoppingCartGivenUnits(shoppingCart, doveSoapProduct, 0);
            });

        Assertions.assertEquals("Error: units has to be a positive number", actualException.getMessage());
    }

    @Test
    void given_totalPrice_is_negative_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> {
                ShoppingCart shoppingCartWithInvalidTotalPrice = new ShoppingCart(new ArrayList<>(),
                    new BigDecimal("-1.00"),
                    new BigDecimal("0.00"), new BigDecimal("0.00"),
                    new BigDecimal("0.00"));
                shoppingCartService.addProductToShoppingCartGivenUnits(shoppingCartWithInvalidTotalPrice,
                    doveSoapProduct,
                    1);
            });

        Assertions.assertEquals("Error: invalid total price", actualException.getMessage());
    }

    @Test
    void given_newProduct_is_null_when_user_adds_products_throw_exception() {
        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class,
            () -> shoppingCartService.addProductToShoppingCartGivenUnits(
                new ShoppingCart(new ArrayList<>(),
                    new BigDecimal("0.00"),
                    new BigDecimal("0.00"),
                    new BigDecimal("0.00"),
                    new BigDecimal("0.00")),
                null,
                1)
        );

        Assertions.assertEquals("Error: new product is null", actualException.getMessage());
    }

    // step 2
    @Test
    void given_empty_shopping_cart_when_adding_additional_same_products_then_shopping_cart_is_as_expected() {
        ShoppingCart shoppingCartWithFiveProducts =
            shoppingCartService.addProductToShoppingCartGivenUnits(emptyShoppingCart, doveSoapProduct, 5);
        ShoppingCart actualShoppingCart =
            shoppingCartService.addProductToShoppingCartGivenUnits(shoppingCartWithFiveProducts, doveSoapProduct, 3);

        Assertions.assertEquals(8, actualShoppingCart.getProducts().size());
        Assertions.assertEquals(8, getCountOfProductsForGivenProduct(actualShoppingCart.getProducts(),
            doveSoapProduct));
        Assertions.assertEquals("319.92", actualShoppingCart.getTotalPriceWithTax().toString());
    }

    // step 3
    @Test
    void given_empty_shopping_cart_when_add_products_with_sales_tax_shopping_cart_is_as_expected() {
        Product axeDeoProduct = new Product("Axe Deo", new BigDecimal("99.99"));

        ShoppingCart emptyShoppingCartServiceWithTaxRate = new ShoppingCart(new ArrayList<>(),
            new BigDecimal("0.00"),
            new BigDecimal("0.00"), new BigDecimal("12.5"),
            new BigDecimal("0.00"));

        ShoppingCart shoppingCartWithTwoDoveSoapProducts = shoppingCartService.addProductToShoppingCartGivenUnits(
            emptyShoppingCartServiceWithTaxRate,
            doveSoapProduct,
            2);

        ShoppingCart actualShoppingCart = shoppingCartService.addProductToShoppingCartGivenUnits(
            shoppingCartWithTwoDoveSoapProducts,
            axeDeoProduct,
            2);

        Assertions.assertEquals(2, getCountOfProductsForGivenProduct(actualShoppingCart.getProducts(),
            doveSoapProduct));
        Assertions.assertEquals(2, getCountOfProductsForGivenProduct(actualShoppingCart.getProducts(),
            axeDeoProduct));

        Assertions.assertEquals(new BigDecimal("35.00"), actualShoppingCart.getTotalSalesTax());
        Assertions.assertEquals(new BigDecimal("314.96"), actualShoppingCart.getTotalPriceWithTax());
    }
}
