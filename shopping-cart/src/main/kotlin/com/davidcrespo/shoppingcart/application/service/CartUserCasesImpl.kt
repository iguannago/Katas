package com.davidcrespo.shoppingcart.application.service

import com.davidcrespo.shoppingcart.application.port.input.CartUseCases
import com.davidcrespo.shoppingcart.application.port.output.CartStore
import com.davidcrespo.shoppingcart.domain.CartOwner
import com.davidcrespo.shoppingcart.domain.Product
import com.davidcrespo.shoppingcart.domain.Receipt
import java.util.*

class CartUserCasesImpl(
    private val store: CartStore
) : CartUseCases {

    override fun createCart(cartOwner: CartOwner): UUID {
        return store.createCart(cartOwner)
    }

    override fun receipt(cartId: UUID, cartOwner: CartOwner): Receipt {
        return store.withCart(cartId, cartOwner) { it.receipt() }
    }

    override fun addProduct(cartId: UUID, cartOwner: CartOwner, product: Product) {
        store.withCart(cartId, cartOwner) { it.add(product) }
    }

    override fun removeProduct(cartId: UUID, cartOwner: CartOwner, productId: String) {
        store.withCart(cartId, cartOwner) { it.remove(productId) }
    }

    override fun applyTwoForOneOffer(cartId: UUID, cartOwner: CartOwner, productId: String) {
        store.withCart(cartId, cartOwner) { it.applyTwoForOneOffer(productId) }
    }
}


