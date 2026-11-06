package com.davidcrespo.shoppingcart.application.port.input

import com.davidcrespo.shoppingcart.domain.Product
import com.davidcrespo.shoppingcart.domain.Receipt
import java.util.UUID

interface CartUseCases {
    fun createCart(): UUID

    fun receipt(cartId: UUID): Receipt

    fun addProduct(cartId: UUID, product: Product)

    fun removeProduct(cartId: UUID, productId: String)

    fun applyTwoForOneOffer(cartId: UUID, productId: String)
}