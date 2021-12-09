package com.equalexpert.shoppingcart;

import java.util.List;

public class ShoppingCartService {
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product newProduct) {
        List<Product> products = shoppingCart.getProducts();
        products.add(newProduct);
        return new ShoppingCart(products, shoppingCart.getTotalPrice().add(newProduct.getPrice()));
    }

}
