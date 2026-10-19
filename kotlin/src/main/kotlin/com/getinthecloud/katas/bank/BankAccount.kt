package com.getinthecloud.katas.bank

import java.math.BigDecimal

class BankAccount {

    private var balance = BigDecimal.ZERO.setScale(2)

    fun balance(): BigDecimal = balance

    fun deposit(amount: BigDecimal) {
        balance += amount.setScale(2)
    }

    fun withdraw(amount: BigDecimal) {
        balance -= amount.setScale(2)
    }
}