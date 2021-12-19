package com.equalexpert.shoppingcart;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartService {

    public ShoppingCart addProductToShoppingCartGivenUnits(ShoppingCart shoppingCart, Product newProduct, int units) {
        validateParameters(shoppingCart, newProduct, units);
        if (units == 1) {
            return addProductToShoppingCartOnce(shoppingCart, newProduct);
        }
        return addProductToShoppingCartGivenUnits(addProductToShoppingCartOnce(shoppingCart, newProduct), newProduct, --units);
    }

    //todo: create custom exceptions (nice)
    private void validateParameters(ShoppingCart shoppingCart, Product newProduct, int units) {
        if (shoppingCart == null) {
            throw new RuntimeException("Error: shopping cart is null");
        }
        if (shoppingCart.getProducts() == null) {
            throw new RuntimeException("Error: product list is null");
        }
        if (shoppingCart.getTotalPrice() == null || shoppingCart.getTotalPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Error: invalid total price");
        }
        if (newProduct == null) {
            throw new RuntimeException("Error: new product is null");
        }
        if (units <= 0) {
            throw new RuntimeException("Error: units has to be a positive number");
        }
    }

    private ShoppingCart addProductToShoppingCartOnce(ShoppingCart shoppingCart, Product newProduct) {
        List<Product> products = shoppingCart.getProducts();
        products.add(newProduct);
        return new ShoppingCart(products, shoppingCart.getTotalPrice().add(newProduct.getPrice()));
    }

}

