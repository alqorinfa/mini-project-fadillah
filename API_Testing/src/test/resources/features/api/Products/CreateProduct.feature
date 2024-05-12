Feature: Create Product
  As a user
  I want to create a product
  So that new product is created

  Scenario: As a user, I can create a product with valid inputs
    Given I set API endpoint for get all products
    When I send request to create a new product
    Then I receive status code 200
    And I receive valid data of new product

  Scenario: As a user, I cannot create a product with empty inputs
    Given I set API endpoint for get all products
    When I send request to create a new product with empty inputs
    Then I receive status code 400
    And I got invalid error message "json: cannot unmarshal string into Go struct field ProductCreate.price of type uint"

  Scenario: As a user, I cannot create a product with invalid price
    Given I set API endpoint for get all products
    When I send request to create a new product with invalid price
    Then I receive status code 400
    And I got invalid error message "json: cannot unmarshal string into Go struct field ProductCreate.price of type uint"
