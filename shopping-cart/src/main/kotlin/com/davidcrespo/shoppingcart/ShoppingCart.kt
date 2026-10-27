package com.davidcrespo.shoppingcart

class ShoppingCart {
    private val quantities = mutableMapOf<String, Int>()

    fun add(product: Product) {
        quantities[product.id] = quantityOf(product.id) + 1
    }

    fun quantityOf(productId: String): Int {
        return quantities.getOrDefault(productId, 0)
    }
}
