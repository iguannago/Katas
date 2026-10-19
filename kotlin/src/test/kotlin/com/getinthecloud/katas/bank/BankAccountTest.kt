package com.getinthecloud.katas.bank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class BankAccountTest {

    private val account: BankAccount = BankAccount()

    @Test
    fun `a new account has a zero balance`() {
        assertEquals(0, account.balance().compareTo(BigDecimal.ZERO.setScale(2)))
    }

    @Test
    fun `depositing money increases the balance`() {
        account.deposit(BigDecimal.TEN)
        assertEquals(0, account.balance().compareTo(BigDecimal.TEN.setScale(2)))
    }

    @Test
    fun `depositing money increases the balance twice`() {
        account.deposit(BigDecimal("0.10"))
        account.deposit(BigDecimal("0.20"))
        assertEquals(0, account.balance().compareTo(BigDecimal.valueOf(0.30).setScale(2)))
    }

    @Test
    fun `withdrawal moeny decreases the balance`() {
        account.deposit(BigDecimal.TEN)
        assertEquals(0, account.balance().compareTo(BigDecimal.TEN.setScale(2)))

        account.withdraw(BigDecimal.TEN)
        assertEquals(0, account.balance().compareTo(BigDecimal.ZERO.setScale(2)))
    }

    @Test
    fun `withdraw to balance zero`() {
        account.deposit(BigDecimal.TEN)
        account.withdraw(BigDecimal.TEN)
        assertEquals(0, account.balance().compareTo(BigDecimal.ZERO.setScale(2)))
    }

    @Test
    fun `depositing money with decimals increases balances`() {
        account.deposit(BigDecimal("0.10"))
        account.deposit(BigDecimal("0.20"))
        assertEquals(0, account.balance().compareTo(BigDecimal.valueOf(0.30)))
    }
}
