package com.davidcrespo.shoppingcart.adapter.inbound.web

import com.davidcrespo.shoppingcart.application.port.input.CartUseCases
import com.davidcrespo.shoppingcart.domain.CartOwner
import com.davidcrespo.shoppingcart.domain.Product
import com.davidcrespo.shoppingcart.domain.Receipt
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/carts")
class CartController(
    private val cartUseCases: CartUseCases
) {

    @PostMapping
    fun createCart(@AuthenticationPrincipal jwt: Jwt): ResponseEntity<CreateCartResponse> {
        val cartId = cartUseCases.createCart(ownerOf(jwt))
        val location = URI.create("/carts/$cartId")

        return ResponseEntity.created(location)
            .body(CreateCartResponse(id = cartId))
    }

    @GetMapping("/{cartId}/receipt")
    fun getReceipt(@PathVariable cartId: UUID, @AuthenticationPrincipal jwt: Jwt): Receipt {
        return cartUseCases.receipt(cartId, ownerOf(jwt))
    }

    @PostMapping("/{cartId}/items")
    fun addProduct(
        @PathVariable cartId: UUID,
        @AuthenticationPrincipal jwt: Jwt,
        @Valid @RequestBody request: AddProductRequest
    ): ResponseEntity<Void> {
        cartUseCases.addProduct(
            cartId,
            ownerOf(jwt),
            Product(id = request.id, name = request.name, price = request.price)
        )

        return ResponseEntity.noContent().build()
    }

    private fun ownerOf(jwt: Jwt): CartOwner {
        val issuer = jwt.issuer?.toString()?.takeIf { it.isNotBlank() }
        val subject = jwt.subject?.takeIf { it.isNotBlank() }

        if (issuer == null || subject == null) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token must identify an issuer and subject")
        }

        return CartOwner(issuer = issuer, subject = subject)
    }
}