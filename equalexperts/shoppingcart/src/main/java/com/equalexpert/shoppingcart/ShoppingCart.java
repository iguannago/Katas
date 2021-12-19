package com.equalexpert.shoppingcart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class ShoppingCart {
    private final List<Product> products;
    private final BigDecimal totalPrice;
    private final BigDecimal totalPriceWithSalesTax;
    private final BigDecimal salesTaxRate;
    private final BigDecimal totalSalesTax;

    public ShoppingCart(List<Product> products,
                        BigDecimal totalPrice,
                        BigDecimal totalPriceWithSalesTax,
                        BigDecimal taxRate,
                        BigDecimal totalSalesTaxRate) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.totalPriceWithSalesTax = totalPriceWithSalesTax;
        this.salesTaxRate = taxRate;
        this.totalSalesTax = totalSalesTaxRate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public BigDecimal getTotalSalesTax() {
        return totalSalesTax;
    }

    public BigDecimal getTotalPriceWithSalesTax() {
        return totalPriceWithSalesTax;
    }

    public BigDecimal getSalesTaxRate() {
        return salesTaxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(products, that.products)
               && Objects.equals(totalPrice, that.totalPrice)
               && Objects.equals(totalPriceWithSalesTax, that.totalPriceWithSalesTax)
               && Objects.equals(salesTaxRate, that.salesTaxRate)
               && Objects.equals(totalSalesTax, that.totalSalesTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPrice, totalPriceWithSalesTax, salesTaxRate, totalSalesTax);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
               "products=" + products +
               ", totalPrice=" + totalPrice +
               ", totalPriceWithSalesTax=" + totalPriceWithSalesTax +
               ", salesTaxRate=" + salesTaxRate +
               ", totalSalesTax=" + totalSalesTax +
               '}';
    }
}
