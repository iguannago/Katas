# Shopping cart

A Kotlin/JVM implementation of a shopping cart supporting product
quantities, removal, itemised receipts and product-specific 2-for-1 offers.

The original domain exercise has been extended with a Spring Boot REST API
on branch `feature/api-extension`. The API extension is in progress.

## Requirements and running tests

- JDK 25
- Internet access on the first build to download Gradle and dependencies

The project includes the Gradle Wrapper; a separate Gradle installation
is not required.

From the project directory:

```bash
./gradlew clean build
```

On Windows:

```bat
gradlew.bat clean build
```

These commands compile the project and run the tests.

## Running the API

```bash
./gradlew bootRun
```

On Windows, use `gradlew.bat bootRun`. The default base URL is
`http://localhost:8080`.

## Architecture

The project follows hexagonal architecture under
`com.davidcrespo.shoppingcart`:

- `domain`: products, carts, receipts and pricing rules; independent of Spring.
- `application.port.input`: `CartUseCases`, the operations exposed to callers.
- `application.port.output`: `CartStore`, the storage and exclusive-access contract.
- `application.service`: `CartUserCasesImpl`, which delegates operations through
  the storage port without depending on Spring or concrete adapters.
- `adapter.inbound.web`: controllers, HTTP request/response models, validation
  and exception handling.
- `adapter.outbound.memory`: `InMemoryCartStore`, which owns cart instances and
  their per-cart locks.
- `configuration`: explicit Spring bean wiring for the ports and implementations.

Tests mirror these packages. The application startup test remains at the root.

## REST API completed so far

| Endpoint | Behaviour | Successful response |
| --- | --- | --- |
| `POST /carts` | Create an independent cart | `201`, JSON `id` and `Location: /carts/{id}` |
| `POST /carts/{id}/items` | Add one product unit | `204`, no body |
| `GET /carts/{id}/receipt` | Return the current structured receipt | `200`, receipt JSON |

Cart IDs are generated UUIDs. Product IDs remain strings. Add-item requests
contain `id`, `name` and `price`. Blank IDs and non-positive prices are rejected
with `400`; validation occurs before the cart operation.

An unknown cart raises `CartNotFoundException`, which the web exception handler
maps to `404` with a `ProblemDetail` body. Validation and other framework errors
do not yet have an explicitly unified error-body contract.

Example requests (replace `<cart-id>` with the returned ID):

```bash
curl -i -X POST http://localhost:8080/carts

curl -i -X POST 'http://localhost:8080/carts/<cart-id>/items' \
  -H 'Content-Type: application/json' \
  -d '{"id":"cornflakes","name":"Cornflakes","price":2.50}'

curl -i 'http://localhost:8080/carts/<cart-id>/receipt'
```

Replace the `<cart-id>` placeholder before running these commands.

## Behaviour and assumptions

- Products are identified by their ID. IDs must not be blank.
- Prices must be strictly greater than zero.
- Adding a product adds one unit.
- Removing a product removes one unit. Removing an absent product
  leaves the cart unchanged.
- Receipts group units by product ID and contain the product details,
  quantity, subtotal, discount and final total.
- The subtotal is the full price before offers. The discount is the
  positive amount saved. The total is subtotal minus discount.
- Prices are interpreted as GBP. Calculations use BigDecimal without
  rounding or enforcing a particular decimal scale.
- The domain cart is not thread-safe by itself. API operations use the storage
  port to synchronise reads and writes on the same cart instance. Different
  carts have separate locks. A concurrent map protects registry access.
- Carts and offers are held only in this process's memory and are lost on restart.
  There is currently no cart expiry or deletion, so storage grows as carts are created.

## Product identity and conflicting details

While a product is present in the cart, adding another product with
the same ID increases its quantity and retains the name and price
from the first addition. Conflicting incoming details are ignored.

For example, adding a product priced at £2.50 followed by a product
with the same ID priced at £3.00 produces a quantity of two, costing
£5.00 before offers.

After all units are removed, adding the same ID again uses the newly
supplied product details.

## Offers

A 2-for-1 offer applies to a specified product ID. Each complete pair
provides one free unit; an unpaired unit costs its normal price.

Different products can independently receive offers. Applying the
same offer repeatedly does not stack discounts.

Eligibility can be set before adding a product and persists after
all units of that product are removed. Discounts are recalculated
from the current quantities whenever a receipt is requested.

## Scope

The solution provides domain functions, a structured receipt and a partial REST
API. It does not include durable persistence, authentication, a frontend or a
printable receipt renderer. Those additions are outside the current API scope.

## TODO and resuming work

Paused after adding API tests for blank product IDs. Non-positive price cases
are also present. These tests check `400` responses and that the cart remains
empty after rejection. The README update did not rerun the tests; start by
running `./gradlew clean build` to establish the current baseline.

Continue one step at a time, with guidance and code examples for manual entry;
wait for confirmation before progressing. Direct edits are only made when
explicitly requested.

- [ ] Next: define and test consistent `ProblemDetail` bodies for validation
  errors and unknown carts, then implement the necessary exception handling.
- [ ] Test malformed JSON, missing/null required fields and malformed cart UUIDs
  return `400` without mutation. Test adding to an unknown cart returns `404`.
- [ ] Add `DELETE /carts/{id}/items/{productId}` returning `204`: remove exactly
  one unit; an absent product is a no-op; an absent cart returns `404`.
- [ ] Add `PUT /carts/{id}/offers/two-for-one/{productId}` returning `204`:
  delegate the existing offer behaviour; an absent cart returns `404`.
- [ ] Cover the new endpoints with integration tests, including updated receipts,
  repeated offer application and independent carts.
- [ ] Add meaningful concurrency tests for same-cart coordination and check
  missing-cart behaviour directly at the memory adapter boundary.
- [ ] Review the final API against its contract, update example requests and
  documentation, and run a clean build with all tests enabled.

Removal and offer operations already exist in the domain and application ports;
their HTTP mappings have not yet been implemented. Do not recreate pricing
logic in controllers or expand into databases, authentication or a frontend.
