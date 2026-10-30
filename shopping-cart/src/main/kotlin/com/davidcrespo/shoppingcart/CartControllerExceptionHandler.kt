package com.davidcrespo.shoppingcart

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(assignableTypes = [CartController::class])
class CartControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException::class)
    fun handleCartNotFound(exception: CartNotFoundException): ProblemDetail {
        return ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            exception.message ?: "Cart not found"
        )
    }
}