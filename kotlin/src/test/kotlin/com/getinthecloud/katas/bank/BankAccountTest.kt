package com.getinthecloud.katas.bank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
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

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["0", "-1", "-10"])
    fun `rejects null, zero and negative deposits`(amount: BigDecimal?) {
        assertThrows<IllegalArgumentException> {
            account.deposit(amount)
        }
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["0", "-1", "-10"])
    fun `rejects null, zero and negative withdrawals`(amount: BigDecimal?) {
        assertThrows<IllegalArgumentException> {
            account.withdraw(amount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.001", "10.501"])
    fun `reject deposits with more than two decimals`(amount: String) {
        assertThrows<IllegalArgumentException> {
            account.deposit(BigDecimal(amount))
        }
    }

    @Test
    fun `these deposits should not be rejected`() {
        account.deposit(BigDecimal("10.5"))
        account.deposit(BigDecimal("10.500"))
        assertEquals(0, BigDecimal("21.00").compareTo(account.balance()))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.001", "10.501"])
    fun `reject withdrawals with more than two decimals`(amount: String) {
        assertThrows<IllegalArgumentException> {
            account.withdraw(BigDecimal(amount))
        }
    }

    @Test
    fun `these withdrawals should not be rejected`() {
        account.deposit(BigDecimal("10.5"))
        account.withdraw(BigDecimal("10.5"))
        account.deposit(BigDecimal("10.500"))
        account.withdraw(BigDecimal("10.500"))
        assertEquals(0, BigDecimal.ZERO.compareTo(account.balance()))
    }

    @Test
    fun `reject withdrawal if resulting balance is negative`() {
        assertThrows<IllegalStateException> {
            account.withdraw(BigDecimal("10.50"))
        }
    }
}
