# Bank account kata

Implement a `BankAccount` using test-driven development. The account holds money in one currency, stores its state in memory and is used by one thread.

Start with the existing `BigDecimal balance()` method. Introduce `deposit(BigDecimal amount)` and `withdraw(BigDecimal amount)` through your tests.

## Requirements

- A new account has a numerically zero balance.
- A deposit increases the balance by the deposited amount.
- A withdrawal decreases the balance by the withdrawn amount.
- Both operations accept only non-null, strictly positive amounts that are exactly representable in two decimal places. For example, `10`, `10.5`, `10.50` and `10.500` are valid; `10.501` is invalid. Do not round silently.
- Reject invalid amounts with `IllegalArgumentException`.
- Reject a valid withdrawal amount greater than the available balance with `IllegalStateException`. No overdraft is allowed.
- Withdrawing the exact balance is allowed and leaves a numerically zero balance.
- Every rejected operation leaves the balance unchanged.
- Reading the balance does not change the account.

Validate the amount before checking whether the account has sufficient funds. An amount that violates the amount rules must produce `IllegalArgumentException`, even if it also exceeds the balance.

Use `BigDecimal` values constructed from decimal strings, such as `new BigDecimal("10.25")`. Compare balances numerically: `BigDecimal.equals` also compares scale, so `10.0` and `10.00` are not equal according to that method. The required balance scale is unspecified.

## Examples

The following operations happen in order on the same account:

| Operation | Expected balance |
| --- | --- |
| Create an account | 0.00 |
| Deposit 100.00 | 100.00 |
| Withdraw 40.25 | 59.75 |
| Deposit 0.10 | 59.85 |
| Deposit 0.20 | 60.05 |
| Withdraw 60.05 | 0.00 |

The balances above are shown to two decimal places for readability; assertions should check numeric value.

For each independent rejection example below, start with a balance of 10.00:

| Operation | Expected result | Balance afterwards |
| --- | --- | --- |
| Deposit or withdraw `null` | `IllegalArgumentException` | 10.00 |
| Deposit or withdraw 0.00 | `IllegalArgumentException` | 10.00 |
| Deposit or withdraw -1.00 | `IllegalArgumentException` | 10.00 |
| Deposit or withdraw 0.001 | `IllegalArgumentException` | 10.00 |
| Withdraw 10.01 | `IllegalStateException` | 10.00 |

## Approach

1. Remove the class-level `@Disabled` annotation from `BankAccountTest`.
2. Run the starter test and observe its failure.
3. Make the initial-balance test pass, then add one behaviour at a time.
4. Cover deposits, withdrawals, repeated operations, exact-balance withdrawal and decimal addition such as 0.10 plus 0.20.
5. Test invalid amounts for both deposit and withdrawal. Assert the exception type and that the balance remains unchanged after rejection.
6. Refactor while keeping the tests green. Keep the design proportionate to the requirements.

From the `createfuture-java25` project directory, run:

```sh
mvn -Dtest=BankAccountTest test
```

Aim for 45–60 minutes. Explain your invariants, test choices, validation order and design trade-offs aloud as you work.

## Optional extension: account statements

After completing the core exercise:

- Record dated deposits and withdrawals, including the balance after each operation.
- Print a statement in reverse chronological order. Agree the exact format and the ordering of transactions with the same date before implementing it.
- Supply time through `Clock` so tests can use fixed dates.
- Keep statement formatting and output separate from account rules when those responsibilities emerge.

Concurrency, transfers, persistence, authentication, multiple currencies and interest are outside the core exercise. This is a practice brief, not CreateFuture's disclosed interview task.
