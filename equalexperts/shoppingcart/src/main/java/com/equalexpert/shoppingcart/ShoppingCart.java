package com.equalexpert.shoppingcart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {
    private final List<Product> products;
    private final BigDecimal totalPrice;

    public ShoppingCart(List<Product> products, BigDecimal totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    //todo: add unit test coverage for these methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(products, that.products) && Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPrice);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
               "products=" + products +
               ", totalPrice=" + totalPrice +
               '}';
    }
}
