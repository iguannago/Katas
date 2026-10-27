package com.davidcrespo.shoppingcart

import java.math.BigDecimal

data class Product(
    val id: String,
    val name: String,
    val price: BigDecimal
)
