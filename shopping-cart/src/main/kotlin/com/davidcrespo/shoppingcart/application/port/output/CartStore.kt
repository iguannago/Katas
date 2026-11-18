package com.davidcrespo.shoppingcart.application.port.output

import com.davidcrespo.shoppingcart.domain.CartOwner
import com.davidcrespo.shoppingcart.domain.ShoppingCart
import java.util.*

interface CartStore {
    fun createCart(owner: CartOwner): UUID

    /**
     * Executes an operation exclusively against a cart belonging to the owner.
     *
     * Operations on the same cart must not overlap.
     * The supplied cart must not escape the operation.
     * Throws CartNotFoundException if the cart is absent or belongs
     * to another owner.
     */
    fun <T> withCart(
        cartId: UUID,
        owner: CartOwner,
        operation: (ShoppingCart) -> T
    ): T

}