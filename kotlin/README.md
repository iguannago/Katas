# Kotlin bank account practice

A standalone Maven project using Kotlin 2.3.21, JDK 25 and JUnit Jupiter 6.0.3. The Kotlin compiler runs inside Maven to keep this small project simple to run.

Open this folder's `pom.xml` as a Maven project in IntelliJ. Select JDK 25 for the project and Maven runner.

## Start here

Read the [bank account scenarios](src/test/kotlin/com/getinthecloud/katas/bank/README.md), then write the first failing test yourself.

- Production code goes in `src/main/kotlin/com/getinthecloud/katas/bank/`.
- Tests go in `src/test/kotlin/com/getinthecloud/katas/bank/`.
- Use package `com.getinthecloud.katas.bank` and name the test class `BankAccountTest`.

No production code or unit tests are supplied. Initially, a successful build means the empty project builds; it does not verify any account behaviour.

## Run

From this directory, with SDKMAN initialised:

```sh
sdk env
mvn clean verify
```

Alternatively, select your JDK 25 through `JAVA_HOME` and `PATH`. Check `mvn -version` reports Java 25.

Once you have created `BankAccountTest`, run just that class:

```sh
mvn -Dtest=BankAccountTest test
```

From the repository root, use `mvn -f kotlin/pom.xml clean verify`.
