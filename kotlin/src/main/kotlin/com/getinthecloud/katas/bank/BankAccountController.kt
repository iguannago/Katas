package com.getinthecloud.katas.bank

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class BankAccountController {

    @PostMapping("/accounts")
    fun createAccount(): BalanceResponse {
        val account = BankAccount()
        account.deposit(BigDecimal("10.00"))

        return BalanceResponse(account.balance())
    }
}

data class BalanceResponse(val balance: BigDecimal)
