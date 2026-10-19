package com.getinthecloud.katas.bank

import java.math.BigDecimal

class BankAccount {

    private var balance = BigDecimal.ZERO.setScale(2)

    fun balance(): BigDecimal = balance

    fun deposit(amount: BigDecimal?) {
        require(amount != null && amount > BigDecimal.ZERO) { "Amount must be greater than zero" }
        require(amount.stripTrailingZeros().scale() <= 2) {
            "Amount must be representable in two decimal places"
        }
        balance += amount.setScale(2)
    }

    fun withdraw(amount: BigDecimal?) {
        require(amount != null && amount > BigDecimal.ZERO) { "Amount must be greater than zero" }
        require(amount.stripTrailingZeros().scale() <= 2) {
            "Amount must be representable in two decimal places"
        }
        check(balance >= amount.setScale(2)) {
            "Insufficient funds"
        }
        balance -= amount.setScale(2)
    }
}