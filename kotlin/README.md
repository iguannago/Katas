# Kotlin bank account practice

A standalone Maven project using Kotlin 2.3.21, JDK 25 and JUnit Jupiter 6.0.3. The Kotlin compiler runs inside Maven to keep this small project simple to run.

Open this folder's `pom.xml` as a Maven project in IntelliJ. Select JDK 25 for the project and Maven runner.

## Start here

The first test and implementation cover a new account's zero balance. Read the [bank account scenarios](src/test/kotlin/com/getinthecloud/katas/bank/README.md), then add the next failing test yourself.

- Production code goes in `src/main/kotlin/com/getinthecloud/katas/bank/`.
- Tests go in `src/test/kotlin/com/getinthecloud/katas/bank/`.
- Use package `com.getinthecloud.katas.bank` and name the test class `BankAccountTest`.

Only the initial-balance scenario is implemented. Deposits, withdrawals and validation remain for you to practise.

## Run

From this directory, with SDKMAN initialised:

```sh
sdk env
mvn clean verify
```

Alternatively, select your JDK 25 through `JAVA_HOME` and `PATH`. Check `mvn -version` reports Java 25.

To run just `BankAccountTest`:

```sh
mvn -Dtest=BankAccountTest test
```

From the repository root, use `mvn -f kotlin/pom.xml clean verify`.
