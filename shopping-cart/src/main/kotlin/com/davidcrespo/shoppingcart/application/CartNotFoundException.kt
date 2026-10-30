package com.davidcrespo.shoppingcart.application

import java.util.UUID

class CartNotFoundException(cartId: UUID) : RuntimeException("Cart not found: $cartId")