package com.davidcrespo.shoppingcart.application.port.input

import com.davidcrespo.shoppingcart.domain.CartOwner
import com.davidcrespo.shoppingcart.domain.Product
import com.davidcrespo.shoppingcart.domain.Receipt
import java.util.UUID

interface CartUseCases {
    fun createCart(cartOwner: CartOwner): UUID

    fun receipt(cartId: UUID, cartOwner: CartOwner): Receipt

    fun addProduct(cartId: UUID, cartOwner: CartOwner, product: Product)

    fun removeProduct(cartId: UUID, cartOwner: CartOwner, productId: String)

    fun applyTwoForOneOffer(cartId: UUID, cartOwner: CartOwner, productId: String)
}