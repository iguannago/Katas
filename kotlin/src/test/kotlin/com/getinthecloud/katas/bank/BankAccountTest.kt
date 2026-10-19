package com.getinthecloud.katas.bank

import java.math.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BankAccountTest {

    @Test
    fun `a new account has a zero balance`() {
        val bankAccount = BankAccount()

        assertEquals(0, bankAccount.balance().compareTo(BigDecimal.ZERO))
    }
}
