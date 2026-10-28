# Shopping cart

## Assumptions and decisions

### Product identity and conflicting details

Products are identified by their ID. While a product is present in the cart,
adding another product with the same ID increases its quantity by one and retains
the name and unit price from the first addition. Conflicting incoming names or
prices are ignored; they do not update or reprice existing units.

For example, adding a product priced at £2.50 and then another product with the
same ID priced at £3.00 produces one receipt line with quantity two and a total
of £5.00 before offers.

This is an explicit assumption because the exercise does not specify how to
handle conflicting details. It keeps the price consistent while that product
remains in the cart. Once all units are removed, adding the same ID again uses
the details supplied by that new addition.
