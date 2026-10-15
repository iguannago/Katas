# CreateFuture Java 25 practice

A standalone Maven project for David's interview preparation. It deliberately has no parent POM: the surrounding katas build uses Java 8 and older Kotlin configuration. Import this folder's `pom.xml` directly into your IDE and select JDK 25 for the project, Maven runner and test runner.

The project uses Java 25 without preview features and JUnit Jupiter 6.0.3. There is no framework, database or mocking dependency. Kata implementations are intentionally unfinished.

## Run

From this directory, with installed Maven:

```sh
sdk env
java -version
mvn -version
mvn clean verify
```

`sdk env` requires SDKMAN to be initialised and the `25-tem` JDK installed. On this machine it is already installed. Alternatively, select your JDK 25 with `JAVA_HOME` and put its `bin` directory first on `PATH`. The initial inspection found Maven using Java 25 while the shell's `java` used Java 21, so check both commands.

From the repository root:

```sh
mvn -f createfuture-java25/pom.xml clean verify
```

Initially only `ProjectSetupTest` executes; the two kata starter tests are explicitly disabled. A green initial build verifies the toolchain and JUnit discovery, **not completed kata behaviour**. Remove a kata's class-level `@Disabled` annotation when you start it, then keep it enabled as you work.

## 1. FizzBuzz — 20 minutes

Implement `FizzBuzz.convert(int)` for positive integers:

| Input | Result |
| --- | --- |
| Ordinary number, e.g. 1 or 2 | Number as text |
| Multiple of 3, e.g. 3 or 6 | `Fizz` |
| Multiple of 5, e.g. 5 or 10 | `Buzz` |
| Multiple of both, e.g. 15 or 30 | `FizzBuzz` |

Practice contract: reject zero and negative values with `IllegalArgumentException`. This is an explicit choice for this exercise; other FizzBuzz variants have different contracts.

1. Remove `@Disabled` from `FizzBuzzTest` and run `mvn -Dtest=FizzBuzzTest test`. Observe the first failure.
2. Make only that test pass, then add the next useful example.
3. Cover both divisibility rules, their overlap, ordinary numbers and invalid inputs. Refactor only when the tests are green.
4. Consider a parameterised test after establishing the behaviour. Explain branch ordering and complexity aloud.

Keep the solution small. A rules engine or an interface for every branch would add little value here. Optional discussion only: how would you add a multiple-of-7 rule if a real requirement appeared?

## 2. Bank account — 45–60 minutes

Start with a single-currency, in-memory, single-threaded account. The starter only fixes `balance()`; evolve the remaining API through tests.

Suggested core contract, agreed here for practice:

- A new account has a numerically zero balance.
- `deposit(BigDecimal)` increases the balance; `withdraw(BigDecimal)` decreases it.
- Accept only non-null, strictly positive amounts exactly representable in two decimal places. Reject invalid amounts with `IllegalArgumentException`; do not round silently.
- Reject a withdrawal greater than the balance with `IllegalStateException`. Withdrawing the exact balance is allowed. No overdraft.
- Every rejected operation leaves the balance unchanged.
- Use decimal strings such as `new BigDecimal("10.25")`. Compare money numerically; `BigDecimal.equals` also compares scale.

Remove `@Disabled` from `BankAccountTest` and start with `mvn -Dtest=BankAccountTest test`. Build tests for the initial balance, deposits, withdrawals, repeated operations, exact-balance withdrawal, invalid amounts and unchanged state after rejection. Include decimal addition such as 0.10 plus 0.20. Run `mvn verify` regularly.

Then, only if time permits, extend to the statement variant of the bank kata:

- Record dated deposits and withdrawals, including the balance after each operation.
- Print a statement in reverse chronological order. Agree its exact format and ordering for same-day transactions before coding.
- Supply time through `Clock` so tests have fixed dates. Keep formatting and output separate when that responsibility emerges.

Concurrency, transfers, persistence, authentication, multiple currencies and interest are outside the initial implementation. Discuss how requirements would change the design before adding them. These are practice choices, not claims about CreateFuture's actual exercise.

## Pairing habits

Clarify the contract, name the next test, make a small change, run it, and explain the trade-off. Ask your partner to challenge ambiguous requirements. Finish by checking failure paths and describing what remains incomplete.

Read [the interview brief](INTERVIEW-BRIEF.md) and [Java and SOLID revision](JAVA-REVISION.md) after the first two katas.
