package com.davidcrespo.shoppingcart.application.port.output

import com.davidcrespo.shoppingcart.domain.ShoppingCart
import java.util.*

interface CartStore {
    fun createCart(): UUID

    /**
     * Executes an operation exclusively against the specified cart.
     *
     * Operations on the same cart must not overlap.
     * The supplied cart must not escape the operation.
     * Throws CartNotFoundException if the cart does not exist.
     */
    fun <T> withCart(
        cartId: UUID,
        operation: (ShoppingCart) -> T
    ): T

}