# Shopping cart

A Kotlin/JVM implementation of a shopping cart supporting product
quantities, removal, itemised receipts and product-specific 2-for-1 offers.

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
- The cart is intended for single-threaded, in-memory use.

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

The solution provides domain functions and a structured receipt.
It does not include a UI, API, persistence or printable receipt renderer.