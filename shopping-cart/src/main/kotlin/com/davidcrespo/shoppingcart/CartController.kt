package com.davidcrespo.shoppingcart

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

data class CreateCartResponse(val id: UUID)

@RestController
@RequestMapping("/carts")
class CartController(
    private val service: CartService
) {

    @PostMapping
    fun createCart(): ResponseEntity<CreateCartResponse> {
        val cartId = service.createCart()
        val location = URI.create("/carts/$cartId")

        return ResponseEntity.created(location)
            .body(CreateCartResponse(id = cartId))
    }

    @GetMapping("/{cartId}/receipt")
    fun getReceipt(@PathVariable cartId: UUID): Receipt {
        return service.receipt(cartId)
    }
}