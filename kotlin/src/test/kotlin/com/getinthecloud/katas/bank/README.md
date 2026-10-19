# Bank account kata — Kotlin

Implement a `BankAccount` in Kotlin, writing one failing unit test at a time before adding production code.

Keep the scope to one currency, an in-memory balance and a single thread. Start with `balance()`, then introduce `deposit(amount)` and `withdraw(amount)`.

Use `BigDecimal` for money, constructed from strings such as `BigDecimal("10.00")`. Compare balances numerically; equality also considers decimal scale.

## Normal scenarios

These steps happen in order on the same account:

| When | Expected balance |
| --- | --- |
| Create an account | 0.00 |
| Deposit 10.00 | 10.00 |
| Deposit another 5.00 | 15.00 |
| Withdraw 4.50 | 10.50 |
| Withdraw the remaining 10.50 | 0.00 |

Also check that depositing 0.10 followed by 0.20 into a new account gives a balance of 0.30.

## Rejected operations

Start each example with a balance of 10.00. Every rejected operation must leave that balance unchanged.

| When | Expected result |
| --- | --- |
| Deposit or withdraw `null` | `IllegalArgumentException` |
| Deposit or withdraw zero | `IllegalArgumentException` |
| Deposit or withdraw a negative amount | `IllegalArgumentException` |
| Deposit or withdraw 1.001 | `IllegalArgumentException` |
| Withdraw 11.00 | `IllegalStateException` |

Amounts must be strictly positive and exactly representable in two decimal places: accept `10`, `10.5` and `10.500`, but reject `10.501`. Do not round silently. Validate the amount before checking available funds.

To practise explicit null validation, use nullable amount parameters (`BigDecimal?`) and reject null with `IllegalArgumentException`.

Start with the new-account scenario and work through the others incrementally. Leave transaction history, timestamps, statements and persistence for a later exercise.
