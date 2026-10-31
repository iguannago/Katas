package com.davidcrespo.shoppingcart.adapter.inbound.web

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class AddProductRequest(
    @field:NotBlank
    val id: String,
    val name: String,
    @field:Positive
    val price: BigDecimal
)