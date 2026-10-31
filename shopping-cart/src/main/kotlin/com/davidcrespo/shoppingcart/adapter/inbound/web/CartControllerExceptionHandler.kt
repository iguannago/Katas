package com.davidcrespo.shoppingcart.adapter.inbound.web

import com.davidcrespo.shoppingcart.application.CartNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationFailure(exception: MethodArgumentNotValidException): ProblemDetail {
        val problem = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST,
            "One or more request fields are invalid"
        )

        val errors = exception.bindingResult.fieldErrors
            .groupBy(
                keySelector = { it.field },
                valueTransform = { it.defaultMessage ?: "Invalid value" }
            )

        problem.setProperty("errors", errors)

        return problem
    }
}