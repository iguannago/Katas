package com.equalexpert.shoppingcart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class ShoppingCart {
    //todo: refactor to use the build pattern (nice)
    private final List<Product> products;
    private final BigDecimal totalPriceWithoutTax;
    private final BigDecimal totalPriceWithTax;
    private final BigDecimal salesTaxRate;
    private final BigDecimal totalSalesTax;

    public ShoppingCart(List<Product> products,
                        BigDecimal totalPrice,
                        BigDecimal totalPriceWithSalesTax,
                        BigDecimal taxRate,
                        BigDecimal totalSalesTaxRate) {
        this.products = products;
        this.totalPriceWithoutTax = totalPrice;
        this.totalPriceWithTax = totalPriceWithSalesTax;
        this.salesTaxRate = taxRate;
        this.totalSalesTax = totalSalesTaxRate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalPriceWithoutTax() {
        return totalPriceWithoutTax;
    }

    public BigDecimal getTotalSalesTax() {
        return totalSalesTax;
    }

    public BigDecimal getTotalPriceWithTax() {
        return totalPriceWithTax;
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
               && Objects.equals(totalPriceWithoutTax, that.totalPriceWithoutTax)
               && Objects.equals(totalPriceWithTax, that.totalPriceWithTax)
               && Objects.equals(salesTaxRate, that.salesTaxRate)
               && Objects.equals(totalSalesTax, that.totalSalesTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, totalPriceWithoutTax, totalPriceWithTax, salesTaxRate, totalSalesTax);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
               "products=" + products +
               ", totalPriceWithoutTax=" + totalPriceWithoutTax +
               ", totalPriceWithTax=" + totalPriceWithTax +
               ", salesTaxRate=" + salesTaxRate +
               ", totalSalesTax=" + totalSalesTax +
               '}';
    }
}
