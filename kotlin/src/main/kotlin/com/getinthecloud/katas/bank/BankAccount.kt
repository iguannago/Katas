package com.getinthecloud.katas.bank

import java.math.BigDecimal

class BankAccount {

    private var balance = BigDecimal.ZERO

    fun balance(): BigDecimal = balance

    fun deposit(amount: BigDecimal) {
        balance += amount
    }

    fun withdraw(amount: BigDecimal) {
        balance -= amount
    }
}