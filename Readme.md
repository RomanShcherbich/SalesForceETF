# Demo project of wrapped elements

The education project demonstrates realization of wrapped element pattern. Also, it has implementation of the following
patterns:

1. Page object
2. Steps
3. Chain of invocations
4. Value object
5. Loadable component

[Saleforce](https://www.salesforce.com/) was used as testing product.

# Test suite

## Test case 1 - Add new account

| step # | desc | expected result |
| --- | --- |  --- |
| 1 | login | main menu loaded |
| 2 | open accounts menu | account view opened |
| 3 | add new account | new account added into account list |


To start test suite exec cmd command:
```mvn test```