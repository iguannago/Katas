package com.equalexpert.shoppingcart;

import java.util.List;

public class ShoppingCartService {

    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product newProduct, int units) {
        if (shoppingCart == null) {
            throw new RuntimeException("Error: shopping cart is null");
        }
        if (shoppingCart.getProducts() == null) {
            throw new RuntimeException("Error: product list is null");
        }
        if (units <= 0) {
            throw new RuntimeException("Error: units has to be a positive number");
        }
        if (units == 1) {
            return addProductOnce(shoppingCart, newProduct);
        }
        return addProduct(addProductOnce(shoppingCart, newProduct), newProduct, --units);
    }

    private ShoppingCart addProductOnce(ShoppingCart shoppingCart, Product newProduct) {
        List<Product> products = shoppingCart.getProducts();
        products.add(newProduct);
        return new ShoppingCart(products, shoppingCart.getTotalPrice().add(newProduct.getPrice()));
    }

}

