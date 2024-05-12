Feature: Get Product By ID
  As a user
  I want to get product by ID
  So that the product can be seen

  Scenario: As a user, I can get product by ID
    Given I set API endpoint for get all products
    When I send request to get product by ID
    Then I receive status code 200
    And I receive data product by ID

  Scenario: As a user, I cannot get product by unexisted ID
    Given I set API endpoint for get all products
    When I send request to get product by unexisted ID
    Then I receive status code 404
    And I receive error message unexisted product "record not found"

