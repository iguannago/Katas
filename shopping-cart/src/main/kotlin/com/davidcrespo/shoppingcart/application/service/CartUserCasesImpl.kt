package com.davidcrespo.shoppingcart.application.service

import com.davidcrespo.shoppingcart.application.port.input.CartUseCases
import com.davidcrespo.shoppingcart.application.port.output.CartStore
import com.davidcrespo.shoppingcart.domain.Product
import com.davidcrespo.shoppingcart.domain.Receipt
import java.util.*

class CartUserCasesImpl(
    private val store: CartStore
) : CartUseCases {

    override fun createCart(): UUID {
        return store.createCart()
    }

    override fun receipt(cartId: UUID): Receipt {
        return store.withCart(cartId) { it.receipt() }
    }

    override fun addProduct(cartId: UUID, product: Product) {
        store.withCart(cartId) { it.add(product) }
    }

    override fun removeProduct(cartId: UUID, productId: String) {
        store.withCart(cartId) { it.remove(productId) }
    }

    override fun applyTwoForOneOffer(cartId: UUID, productId: String) {
        store.withCart(cartId) { it.applyTwoForOneOffer(productId) }
    }
}


