package com.davidcrespo.shoppingcart.domain

data class CartOwner(
    val issuer: String,
    val subject: String
) {
    init {
        require(issuer.isNotBlank()) { "Owner issuer cannot be blank" }
        require(subject.isNotBlank()) { "Owner subject cannot be blank" }
    }
}