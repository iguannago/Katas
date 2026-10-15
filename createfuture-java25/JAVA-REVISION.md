# Java interview refresh

David, use this as a spoken rehearsal: answer each question in 60–90 seconds, then give one production example and explain a trade-off. This project uses Java 25; confirm the interview environment rather than assuming its version.

## Fifteen high-yield questions

1. **How do you start an unfamiliar paired exercise?**
   Restate the behaviour, clarify ambiguous rules, write one small example and agree the next test. Explain your reasoning while coding; invite feedback and keep changes small. For FizzBuzz clarify range and invalid inputs; for the bank account clarify withdrawals, overdrafts, money precision, statement ordering and formatting. Do not invent extra requirements.

2. **What is the `equals`/`hashCode` contract, and why does it matter?**
   Equality is reflexive, symmetric, transitive and consistent; a non-null object is unequal to null. Equal objects must have equal hashes; matching hashes do not prove equality. Keep map-key equality fields stable while stored, and test value-object equality deliberately. See [the Object contract](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object)).

3. **Which collection would you choose, and what are its costs?**
   Start with the access pattern: an ordered transaction sequence suggests a list; lookup by account ID suggests a map; uniqueness suggests a set. `HashMap` basic lookup/update is expected O(1) with suitable hash distribution, has no iteration-order guarantee and is not thread-safe. Choose a sorted or insertion-ordered implementation only when required. See [HashMap](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/HashMap.html).

4. **Are records and `final` enough to guarantee immutability?**
   No. A final reference can point to mutable state, and records are only shallowly immutable. Validate construction, copy mutable inputs and avoid exposing internal mutable objects. `List.copyOf` provides an unmodifiable list whose structure does not follow later input changes; its elements may still mutate. See [Record](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Record.html) and [List](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/List.html#unmodifiable).

5. **How would you represent and compare money?**
   Agree currency, scale and rounding rules. Use decimal input with `BigDecimal`, or integer minor units with explicit range/currency rules; avoid binary floating-point arithmetic for exact decimal amounts. `new BigDecimal("2.0")` and `new BigDecimal("2.00")` compare numerically equal but are unequal via `equals`, which includes scale. Normalise only according to the domain contract. See [BigDecimal](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/math/BigDecimal.html).

6. **Where should validation and exceptions live?**
   Validate transport syntax at the boundary and enforce business invariants in the domain as well. Decide explicitly whether zero, negative amounts and insufficient funds are allowed; a rejected operation must leave state unchanged. Choose an exception or explicit result to match the agreed API, preserve causes when translating failures and avoid swallowing errors or logging sensitive account data.

7. **What makes a useful unit test?**
   Assert observable behaviour with clear setup, action and outcome. Cover normal behaviour, boundaries, invalid input and unchanged state after rejection. For the bank account, include exact-balance withdrawal, decimal precision, multiple operations and statement ordering; test only rules actually agreed. Prefer a few revealing examples over implementation-coupled assertions or a coverage target.

8. **How do you keep tests deterministic without over-mocking?**
   Keep business logic independent of I/O. Inject time when dates affect behaviour, and isolate output or persistence only when needed. Use real value objects and simple in-memory collaborators; mock external boundaries when interaction itself matters. Avoid sleeps in concurrency tests: coordinate starts/completion and assert the invariant, while acknowledging that one passing run does not prove race freedom.

9. **When do streams and `Optional` improve the code?**
   Use streams for clear transformations, with non-interfering behaviour; a loop is often clearer for ordered state changes and early exits. Do not mutate shared state inside a parallel stream. `Optional` mainly expresses a possibly absent return value; it is not a replacement for every null or for validation errors. See [streams](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/package-summary.html) and [Optional](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Optional.html).

10. **What is the difference between visibility and atomicity?**
    Visibility concerns which writes another thread can observe; atomicity concerns an operation appearing indivisible. `volatile` provides visibility/ordering guarantees but does not make a read–modify–write such as increment atomic. A shared lock can protect a compound invariant; atomic classes provide particular atomic operations. See [the Java memory model](https://docs.oracle.com/javase/specs/jls/se25/html/jls-17.html#jls-17.4.5) and [atomic classes](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/atomic/package-summary.html).

11. **Why is a thread-safe collection insufficient for concurrent withdrawals?**
    Checking funds and applying the debit is a compound operation; transaction history and balance may also need to change together. Protect the entire invariant, not just individual reads/writes. A JVM lock works within that process only; multiple service instances require a database concurrency strategy or another shared coordination mechanism. Introduce this complexity only if concurrency is in scope.

12. **Which Java 17/21/25 features can you discuss accurately?**
    Records and `instanceof` patterns were final by Java 16; sealed classes in 17. Record patterns and pattern-matching `switch` became final in 21. Java 25 finalises flexible constructor bodies, module imports and compact source files/instance main methods. Primitive patterns remain preview in 25; structured concurrency is also preview. Use stable features for this practice unless preview is explicitly wanted. See [language changes](https://docs.oracle.com/en/java/javase/25/language/java-language-changes-summary.html) and [JDK 25 changes](https://docs.oracle.com/en/java/javase/25/migrate/significant-changes-jdk-25.html).

13. **When would you use virtual threads?**
    They became final in Java 21 and suit large numbers of tasks that spend time waiting, such as blocking I/O. They do not speed up CPU-bound work or remove data races. Do not pool virtual threads; bound scarce resources such as database connections independently. Check pinning behaviour against the target JDK rather than repeating older version-specific advice. See [virtual threads](https://docs.oracle.com/en/java/javase/25/core/virtual-threads.html).

14. **What commonly goes wrong with Spring `@Transactional`?**
    With default proxy mode, self-invocation bypasses transactional interception; an inner annotation does not create a new boundary. By default, unchecked exceptions and errors trigger rollback, while checked exceptions do not; configuration can change this. Catching a failure can also hide it from the interceptor. Keep the boundary explicit, avoid slow remote calls inside it, and test rollback through the Spring-managed bean. See [transaction semantics](https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative/annotations.html).

15. **What commonly goes wrong with Spring caching?**
    Default proxy-mode `@Cacheable` also ignores self-invocation. Cache keys must cover the relevant identity, including tenant/currency when applicable; decide eviction and permitted staleness. A cached balance must not become the authority for authorising a debit. Verify behaviour through the bean and the actual cache configuration. See [cache annotations](https://docs.spring.io/spring-framework/reference/integration/cache/annotations.html).

## SOLID as practical judgement

| Principle | Bank-account example | Avoid overdoing it |
| --- | --- | --- |
| Single responsibility | Separate account rules from statement formatting when both need independent change. | One responsibility is a reason to change, not a one-method-class rule. |
| Open/closed | Introduce a fee or output-format strategy when a real variation is required. | Do not predict a framework of future rules for FizzBuzz. |
| Liskov substitution | Every account implementation must honour the agreed withdrawal and failure contract. | A subtype that silently changes overdraft rules may violate callers' assumptions. |
| Interface segregation | A statement reader need not depend on deposit/withdraw operations. | Do not create an interface for every class. |
| Dependency inversion | Business rules can depend on a small persistence/output abstraction when that boundary exists. | Begin with plain Java; add adapters to meet requirements, not to demonstrate patterns. |

Prefer composition, clear names, small cohesive methods and explicit invariants. Apply DRY to duplicated knowledge; similar-looking code does not always represent the same rule. Refactor once the tests and requirements reveal the useful abstraction.

## One system-design rehearsal: a wallet API

**Prompt:** Design deposit, withdrawal and balance endpoints. Clients retry after timeouts; two requests may spend the same balance concurrently; an audit history is required.

Talk through these decisions in order:

1. Clarify currency, overdrafts, latency/scale, authentication/ownership, retention and consistency expectations before drawing services.
2. Specify request/response contracts and an idempotency key scoped to the relevant caller/operation. Store a request fingerprint and outcome; reject reuse with a different request.
3. Make the idempotency decision, conditional debit and ledger entry one atomic database transaction. Use constraints and an explicit locking/version strategy so concurrent debits cannot overspend.
4. Explain the failure cases: simultaneous duplicates, timeout after commit, crash before response, retry after retention expiry and contention. Never claim that transport delivery alone is exactly-once business execution.
5. If events are required, discuss a transactional outbox plus idempotent consumers; start with one service and a suitable database until requirements justify more components.
6. Cover reconciliation, audit access, sensitive logging, metrics and failure-focused tests. State what changes if availability is preferred over immediate balance consistency.

This is a rehearsal prompt, not a claim about the interview's actual design question.

## Three experience questions

- **Tell me about an ambiguous requirement or a design disagreement.** Explain how you clarified the customer outcome, compared options, collaborated and checked the result.
- **Tell me about a production incident or a decision you would change.** Describe your own contribution, evidence, mitigation, root cause and what you changed afterwards. Distinguish measured results from estimates.
- **Tell me how you helped another engineer or improved a team's quality.** Give a specific example of feedback, pairing or a test/review improvement; explain how you adapted to the other person's perspective and what improved.

Prepare concise situation → responsibility → actions → result → learning stories. Use real examples and your own contribution; keep client names and sensitive details out.
