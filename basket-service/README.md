# Interview task: Basket Service

Our team is implementing a Basket Service to calculate the cost of subscriptions that the customer wishes to buy.

Your task is to implement the `BasketService` interface.

Subscription prices are retrieved via the `SubscriptionService` interface. You are not expected to implement this, consider it a third party.

JUnit must be used to unit test `BasketService` against the provided Acceptance Criteria. Third party services should be mocked.

We have the following features that we want to implement. Please complete each feature in it's own commit.

When you are finished, make sure you provide a git-bundle, so we can see your local history (see docs [here](https://git-scm.com/docs/git-bundle)).


[11:03] Grimshaw, Richard (Senior Developer)
https://www.dropbox.com/s/xe9ej4edzkfd7j6/basket-service.zip?dl=1
​[11:07] Grimshaw, Richard (Senior Developer)
# Interview task: Basket Service

Our team is implementing a Basket Service to calculate the cost of subscriptions that the customer wishes to buy.
Your task is to implement the `BasketService` interface.
Subscription prices are retrieved via the `SubscriptionService` interface. You are not expected to implement this, consider it a third party.
JUnit must be used to unit test `BasketService` against the provided Acceptance Criteria. Third party services should be mocked.
We have the following features that we want to implement. Please complete each feature in it's own commit.
When you are finished, make sure you provide a git-bundle, so we can see your local history (see docs [here](https://git-scm.com/docs/git-bundle)).
​[11:10] Grimshaw, Richard (Senior Developer)
## Part 1 - Implement Basket Service:

Multiple Subscriptions exist:
```
- ENTERTAINMENT £9.99
- SPORTS £19.99
- KIDS £6.99
```
Acceptance Criteria:
```
Scenario: Successful basket calculation of a single subscription
Given the customer wants to purchase an ENTERTAINMENT subscription
When the basket is calculated
Then a successful response is returned with £9.99 as the charge
```
```
Scenario: Unknown subscription should return SubscriptionNotFound exception
Given the customer wants to purchase a MOVIES subscription
And the SubscriptionService does not return a price (returns null)
When the basket is calculated
Then a SubscriptionNotFound exception is thrown
```
```
Scenario: Successful basket calculation of multiple subscriptions
Given the customer wants to purchase ENTERTAINMENT and SPORTS subscriptions
When the basket is calculated
Then a successful response is returned with £29.98 as the charge

```



11:03
https://www.dropbox.com/s/xe9ej4edzkfd7j6/basket-service.zip?dl=1

# Interview task: Basket Service

Our team is implementing a Basket Service to calculate the cost of subscriptions that the customer wishes to buy.


Your task is to implement the `BasketService` interface.


Subscription prices are retrieved via the `SubscriptionService` interface. You are not expected to implement this, consider it a third party.


JUnit must be used to unit test `BasketService` against the provided Acceptance Criteria. Third party services should be mocked.


We have the following features that we want to implement. Please complete each feature in it's own commit.


When you are finished, make sure you provide a git-bundle, so we can see your local history (see docs [here](https://git-scm.com/docs/git-bundle)).

## Part 1 - Implement Basket Service:

Multiple Subscriptions exist:


```
- ENTERTAINMENT £9.99
- SPORTS £19.99
- KIDS £6.99
```


Acceptance Criteria:
```
Scenario: Successful basket calculation of a single subscription
Given the customer wants to purchase an ENTERTAINMENT subscription
When the basket is calculated
Then a successful response is returned with £9.99 as the charge
```


```
Scenario: Unknown subscription should return SubscriptionNotFound exception
Given the customer wants to purchase a MOVIES subscription
And the SubscriptionService does not return a price (returns null)
When the basket is calculated
Then a SubscriptionNotFound exception is thrown
```


```
Scenario: Successful basket calculation of multiple subscriptions
Given the customer wants to purchase ENTERTAINMENT and SPORTS subscriptions
When the basket is calculated
Then a successful response is returned with £29.98 as the charge
```

12:03
Part 2 - Enhance Basket Service to use Customer Service
We would now like you to enhance the Basket Service to additionally accept a Customer ID

The CustomerService is used to retrieve customer subscriptions. Similarly to the SubscriptionService, you are not expected to implement this, consider it a third party.

Also, another type of subscription has been introduced:

BOOST £1.99 (can only be added if the customer has another subscription)
Acceptance Criteria:

Scenario: Successful basket calculation of a BOOST subscription
Given the customer has an existing ENTERTAINMENT subscription
And the customer wants to purchase a BOOST subscription
When the basket is calculated
Then a successful response is returned with £1.99 as the charge



Scenario: Basket conditions not met should return BasketConditionNotMetException
Given the customer does not have any existing subscriptions
And the customer wants to purchase a BOOST subscription
When the basket is calculated
Then a BasketConditionNotMetException exception is thrown

