package com.getinthecloud.katas.bank

import java.math.BigDecimal

class BankAccount {

    private var balance = BigDecimal.ZERO.setScale(2)

    fun balance(): BigDecimal = balance

    fun deposit(amount: BigDecimal?) {
        require(amount != null && amount > BigDecimal.ZERO) { "Amount must be greater than zero" }
        require(amount.scale() <= 2) { "Amount must have at most 2 decimal places" }
        balance += amount.setScale(2)
    }

    fun withdraw(amount: BigDecimal?) {
        require(amount != null && amount > BigDecimal.ZERO) { "Amount must be greater than zero" }
        balance -= amount.setScale(2)
    }
}