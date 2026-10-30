package com.davidcrespo.shoppingcart.domain

import java.math.BigDecimal

data class Product(val id: String, val name: String, val price: BigDecimal) {
    init {
        require(price > BigDecimal.ZERO) { "Price must be positive" }
        require(id.isNotBlank()) { "Id must not be blank" }
    }
}
