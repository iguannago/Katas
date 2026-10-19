# Kotlin bank account practice

A standalone Maven project using Kotlin 2.3.21, JDK 25, JUnit Jupiter 6.0.3 and Spring Boot 4.1.1. The Kotlin compiler runs inside Maven to keep this small project simple to run.

Open this folder's `pom.xml` as a Maven project in IntelliJ. Select JDK 25 for the project and Maven runner.

## Start here

Read the [bank account scenarios](src/test/kotlin/com/getinthecloud/katas/bank/README.md) for the core behaviour and validation rules.

- Production code goes in `src/main/kotlin/com/getinthecloud/katas/bank/`.
- Tests go in `src/test/kotlin/com/getinthecloud/katas/bank/`.
- Use package `com.getinthecloud.katas.bank` and name the test class `BankAccountTest`.

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

## Run the HTTP endpoint

From this directory, with JDK 25 selected:

```sh
mvn spring-boot:run
```

Then, in another terminal:

```sh
curl -X POST http://localhost:8080/accounts
```

The endpoint returns HTTP 200 with:

```json
{"balance":10.00}
```

Each request creates a fresh account and deposits `10.00`. Accounts are not persisted or shared between requests.
