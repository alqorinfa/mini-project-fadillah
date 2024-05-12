Feature: Create Order
  As a user
  I want to create an order
  So that my order is created

  Scenario: As a user, I can create order with valid inputs
    Given I set API endpoint for all order
    When I send request to create order with valid inputs
    Then I receive status code 200
    And I receive the order data

  Scenario: As a user, I cannot create order with invalid ID
    Given I set API endpoint for all order
    When I send request to create order with invalid ID
    Then I receive status code 400
    And I got invalid ID error message "json: cannot unmarshal string into Go struct field OrderCreate.product_id of type uint"

  Scenario: As a user, I cannot create order with no quantity
    Given I set API endpoint for all order
    When I send request to create order with no quantity
    Then I receive status code 400
