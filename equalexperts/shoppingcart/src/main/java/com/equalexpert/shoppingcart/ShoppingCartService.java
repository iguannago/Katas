package com.equalexpert.shoppingcart;

import java.util.List;

public class ShoppingCartService {

    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product newProduct, int units) {
        if (units == 1) {
            return addProductOnce(shoppingCart, newProduct);
        }
        return addProduct(addProductOnce(shoppingCart, newProduct), newProduct, --units);
    }

    public ShoppingCart addProductOnce(ShoppingCart shoppingCart, Product newProduct) {
        List<Product> products = shoppingCart.getProducts();
        products.add(newProduct);
        return new ShoppingCart(products, shoppingCart.getTotalPrice().add(newProduct.getPrice()));
    }

}

