package com.davidcrespo.shoppingcart.adapter.inbound.web

import com.davidcrespo.shoppingcart.application.port.input.CartUseCases
import com.davidcrespo.shoppingcart.domain.Product
import com.davidcrespo.shoppingcart.domain.Receipt
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/carts")
class CartController(
    private val cartUseCases: CartUseCases
) {

    @PostMapping
    fun createCart(): ResponseEntity<CreateCartResponse> {
        val cartId = cartUseCases.createCart()
        val location = URI.create("/carts/$cartId")

        return ResponseEntity.created(location)
            .body(CreateCartResponse(id = cartId))
    }

    @GetMapping("/{cartId}/receipt")
    fun getReceipt(@PathVariable cartId: UUID): Receipt {
        return cartUseCases.receipt(cartId)
    }

    @PostMapping("/{cartId}/items")
    fun addProduct(
        @PathVariable cartId: UUID,
        @Valid @RequestBody request: AddProductRequest
    ): ResponseEntity<Void> {
        cartUseCases.addProduct(cartId, Product(id = request.id, name = request.name, price = request.price))

        return ResponseEntity.noContent().build()
    }
}