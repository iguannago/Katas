package com.equalexpert.shoppingcart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class ShoppingCart {
    private final List<Product> products;
    private final BigDecimal totalPrice;
    private final BigDecimal taxRate;

    public ShoppingCart(List<Product> products, BigDecimal totalPrice, BigDecimal taxRate) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.taxRate = taxRate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(products, that.products) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(taxRate, that.taxRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPrice, taxRate);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
               "products=" + products +
               ", totalPrice=" + totalPrice +
               ", taxRate=" + taxRate +
               '}';
    }
}
